package com.scala.common.rabbitmqUtils

import org.apache.spark.internal.Logging
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.receiver.Receiver


class RabbitMQInputDStream(
                            @transient ssc_ : StreamingContext,
                            rabbitMQQueueName: Option[String],
                            rabbitMQHost: String,
                            rabbitMQPort: Int,
                            virtualhost: String,
                            username: String,
                            password: String,
                            exchangeName: Option[String],
                            routingKeys: Seq[String],
                            DirectExchangeType: Option[String],
                            ack: Boolean,
                            autoDelete: Boolean,
                            prefetchCount: Int,
                            streamingtime: Int,
                            storageLevel: StorageLevel
                          ) extends ReceiverInputDStream[String](ssc_) with Logging {

  override def getReceiver(): Receiver[String] = {
    val DefaultRabbitMQPort = 5672

    new RabbitMQReceiver(
      rabbitMQQueueName,
      Some(rabbitMQHost).getOrElse("localhost"),
      Some(rabbitMQPort).getOrElse(DefaultRabbitMQPort),
      virtualhost,
      username,
      password,
      exchangeName,
      routingKeys,
      DirectExchangeType.getOrElse("direct"),
      ack,
      autoDelete,
      prefetchCount,
      streamingtime,
      storageLevel)
  }
}


