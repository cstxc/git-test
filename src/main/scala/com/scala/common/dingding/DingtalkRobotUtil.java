package com.scala.common.dingding;

import com.alibaba.fastjson.JSON;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.junit.Test;

import java.io.IOException;
import java.sql.DriverManager;
import java.util.Map;

import static com.scala.common.dingding.MapFactory.of;


/**
 * Created by KAI on 2017/11/15.
 * ectest@foxmail.com
 */
public class DingtalkRobotUtil {
    private final static String URL = "https://oapi.dingtalk.com/robot/send?access_token=f1cfe7e766ba954d471af232e5fe06f6a72ade3080c61e7a625ea0add0895300";

    /**
     * 发送文字消息
     *
     * @param message
     * @return
     */

    public static String messageText(String message, String[] at, boolean isAtAll) {

        Map<String, Object> map = of(
                "msgtype", "text",
                "text", of("content", message),
                "at", of("atMobiles", at),
                "isAtAll", isAtAll
        );

        return post(map);
    }

    /**
     * 发送超链接消息
     *
     * @param text
     * @param title
     * @param picUrl
     * @param messageUrl
     * @return
     */

    public static String messageLink(String text, String title, String picUrl, String messageUrl, String[] at, boolean isAtAll) {

        Map<String, Object> map = of(
                "msgtype", "link",
                "link", of("text", text, "title", title, "picUrl", picUrl, "messageUrl", messageUrl),
                "at", of("atMobiles", at),
                "isAtAll", isAtAll
        );

        return post(map);
    }

    /**
     * 发送 markdown 消息
     *
     * @param text
     * @param title
     * @return
     */

    public static String messageMarkdown(String text, String title, String[] at, boolean isAtAll) {

        Map<String, Object> map = of(
                "msgtype", "markdown",
                "markdown", of("text", text, "title", title),
                "at", of("atMobiles", at),
                "isAtAll", isAtAll
        );

        return post(map);
    }


    private static String post(Map body) {

        String returnString = null;

        try {
            returnString = Request.Post(URL).connectTimeout(3000)
                    .bodyString(JSON.toJSONString(body), ContentType.APPLICATION_JSON).execute().returnContent().asString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnString;

    }

    @Test
    public void test() {
        Long begin = System.currentTimeMillis();
        MapFactory mapFactory = new MapFactory();
        mapFactory
                .put("msgtype", "markdown")
                .put("markdown", new MapFactory()
                        .put("text", "![zhihu趣图(markdown)](https://pic1.zhimg.com/80/v2-225c88cab004d4f2a1dc8003db2d7703_720w.jpg)")
                        .put("title", "知乎趣图测试").getMap())
                .put("at", new MapFactory().put("atMobiles", new String[]{"1", "2"}).getMap())
                .put("isAtAll", true);
        Long end = System.currentTimeMillis();

        post(mapFactory.getMap());
        System.out.println((end - begin) + "ms");
    }


    public void test_mysql() {
        Long begin = System.currentTimeMillis();
        MapFactory mapFactory = new MapFactory();
        mapFactory
                .put("msgtype", "markdown")
                .put("markdown", new MapFactory().put("text", "![zhihu趣图(markdown)](https://pic1.zhimg.com/80/v2-225c88cab004d4f2a1dc8003db2d7703_720w.jpg)").put("title", "知乎趣图测试").getMap())
                .put("at", new MapFactory().put("atMobiles", new String[]{"1", "2"}).getMap())
                .put("isAtAll", true);
        Long end = System.currentTimeMillis();
        post(mapFactory.getMap());
        System.out.println((end - begin) + "ms");
    }


}
