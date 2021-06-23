package com.scala.common.rabbitmqUtils

import java.util.concurrent.atomic.AtomicInteger

import com.rabbitmq.client.{Channel, Connection, ConnectionFactory, QueueingConsumer}
import org.apache.commons.lang.StringUtils
import org.apache.spark.internal.Logging
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.receiver.Receiver

import scala.util.{Failure, Success, Try}
class RabbitMQReceiver(rabbitMQQueueName: Option[String],
                       rabbitMQHost: String,
                       rabbitMQPort: Int,
                       virtualhost: String,
                       username: String,
                       password: String,
                       exchangeName: Option[String],
                       routingKeys: Seq[String],
                       DirectExchangeType: String,
                       ack: Boolean,
                       autoDelete: Boolean,
                       prefetchCount: Int,
                       streamingtime: Int,
                       storageLevel: StorageLevel)
  extends Receiver[String](storageLevel) with Logging {

  private val count: AtomicInteger = new AtomicInteger(0)

  def onStart() {
    implicit val akkaSystem = akka.actor.ActorSystem()
    getConnectionAndChannel match {
      case Success((connection: Connection, channel: Channel)) => receive(connection, channel, ack)
      case Failure(f) => log.error("Could not connect"); restart("Could not connect", f)
    }
  }

  def onStop() {
    // There is nothing much to do as the thread calling receive()
    // is designed to stop by itself isStopped() returns false
  }

  /** Create a socket connection and receive data until receiver is stopped */
  private def receive(connection: Connection, channel: Channel, ack: Boolean) {

    val queueName = !routingKeys.isEmpty match {
      case true => {

        if (prefetchCount > 0) {
          channel.basicQos(prefetchCount)
        }

        // exchangeName   存在 会报错  ,比如使用 amq.topic
        // channel.exchangeDeclare(exchangeName.get, DirectExchangeType)


        channel.exchangeDeclarePassive(exchangeName.get)

        channel.queueDeclare(rabbitMQQueueName.get, false, false, autoDelete, null)

        for (routingKey: String <- routingKeys) {
          channel.queueBind(rabbitMQQueueName.get, exchangeName.get, routingKey)
        }
        rabbitMQQueueName.get
      }
      case false => {
        // channel.queueDeclare(rabbitMQQueueName.get, false, false, false, new util.HashMap(0))
        rabbitMQQueueName.get
      }
    }

    log.info("RabbitMQ Input waiting for messages")
    val consumer: QueueingConsumer = new QueueingConsumer(channel)


    channel.basicConsume(queueName, ack, consumer)

    while (!isStopped) {


      if (count.get() < prefetchCount) {
        val delivery: QueueingConsumer.Delivery = consumer.nextDelivery
        val body = new String(delivery.getBody)
        if (StringUtils.isNotEmpty(body)) {
          store(body)
        }

        if (!ack) {
          channel.basicAck(delivery.getEnvelope().getDeliveryTag(), ack)
        }


        count.incrementAndGet()
      } else {


        Thread.sleep((streamingtime) * 1000)
        count.set(0)
      }

    }

    log.info("rabbitmq  streaming  it has been stopped ...............")
    channel.close
    connection.close
    restart("Trying to connect again............")
  }

  private def getConnectionAndChannel: Try[(Connection, Channel)] = {
    for {
      connection: Connection <- Try(getConnectionFactory.newConnection())
      channel: Channel <- Try(connection.createChannel)
    } yield {
      (connection, channel)
    }
  }

  private def getConnectionFactory: ConnectionFactory = {
    val factory: ConnectionFactory = new ConnectionFactory

    if (StringUtils.isNotEmpty(rabbitMQHost)) {
      factory.setHost(rabbitMQHost)

    }
    if (rabbitMQPort != 0) {
      factory.setPort(rabbitMQPort)
    }

    factory.setConnectionTimeout(1000)
    if (StringUtils.isNotEmpty(virtualhost)) {
      factory.setVirtualHost(virtualhost)
    }
    if (StringUtils.isNotEmpty(username)) {
      factory.setUsername(username)
    }
    if (StringUtils.isNotEmpty(password)) {
      factory.setPassword(password)

    }


    factory
  }
}