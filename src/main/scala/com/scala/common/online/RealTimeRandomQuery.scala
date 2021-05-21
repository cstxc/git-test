package com.scala.common.online

import java.sql.{Connection, DriverManager, ResultSet, Statement}

/*
       *@ClassName  RealTimeRandomQuery
       *@description    TODO
       *@author     cs_txc@aliyun.com
       *@date   2021/5/21  18:17
       *@version 1.0
       java -classpath /home/myjar/mysql-connector-java-5.1.32.jar:/home/myjar/git-test.jar com.scala.common.online.RealTimeRandomQuery

       nohup /home/myjar/random_print.sh >> x.log 2>&1 &
*/
object RealTimeRandomQuery {
  def main(args: Array[String]): Unit = {
    val start = System.currentTimeMillis()

    val conn: Connection = DriverManager.getConnection("jdbc:mysql://60.190.133.139:3306/VTTD", "root", "mBnkvj2HKjvnxHES8rqXH")
    val stat: Statement = conn.createStatement()

    while (true){
      val rs: ResultSet = stat.executeQuery(" SELECT CUSTOMNAME from CUSTOM")
      while (rs.next()){
        val name = rs.getString("CUSTOMNAME")
        println(name)
      }

      Thread.sleep(5000)
    }




  }
}
