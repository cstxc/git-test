package com.scala.common.flinkproject

import org.apache.flink.streaming.api.scala._

/*
       *@ClassName  StreamingWordCount
       *@description    TODO
       *@author     cs_txc@aliyun.com
       *@date   2021/6/23  18:14
       *@version 1.0
*/

// nc -lk 7777

object StreamingWordCount {
  def main(args: Array[String]): Unit = {
    val ev = StreamExecutionEnvironment.getExecutionEnvironment

    val ds: DataStream[String] = ev.socketTextStream("localhost", 7777)

    val rs: DataStream[(String, Int)] = ds.flatMap(_.split(" "))
      .filter(_.nonEmpty)
      .map((_, 1))
      .keyBy(0)
      .sum(1)

    rs.print()

    ev.execute()
  }
}
