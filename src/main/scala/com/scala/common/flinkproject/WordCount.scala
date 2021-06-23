package com.scala.common.flinkproject

import org.apache.flink.api.scala.{ExecutionEnvironment, _}


/*
       *@ClassName  WordCount
       *@description    TODO
       *@author     cs_txc@aliyun.com
       *@date   2021/6/23  17:24
       *@version 1.0
*/
object WordCount {
  def main(args: Array[String]): Unit = {
    val ev = ExecutionEnvironment.getExecutionEnvironment

    val path = "D:\\ProjectHome\\git-test\\src\\main\\resources\\a.txt"

    val data: DataSet[String] = ev.readTextFile(path)
    val value: AggregateDataSet[(String, Int)] = data.flatMap(_.split(" "))
      .map((_, 1))
      .groupBy(0)
      .sum(1)

    value.print()


  }
}
