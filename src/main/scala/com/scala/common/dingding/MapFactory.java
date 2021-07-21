package com.scala.common.dingding;

import java.util.HashMap;


public class MapFactory {
    /**
     * 更少的代码封装参数
     */
    private HashMap<String, Object> map = new HashMap<String, Object>();

    public HashMap<String, Object> getMap() {
        return map;
    }

    public com.scala.common.dingding.MapFactory setMap(HashMap<String, Object> map) {
        this.map = map;
        return this;
    }

    public com.scala.common.dingding.MapFactory put(String k1, Object v1) {
        map.put(k1, v1);
        return this;
    }
    /**
     * 更少的代码封装参数
     */



    public static HashMap<String, Object> of() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        return map;
    }

    public static HashMap<String, Object> of(String k1, Object v1) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(k1, v1);
        return map;
    }

    public static HashMap<String, Object> of(String k1, Object v1, String k2, Object v2) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    public static HashMap<String, Object> of(String k1, Object v1, String k2, Object v2, String k3, Object v3) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return map;
    }

    public static HashMap<String, Object> of(String k1, Object v1, String k2, Object v2, String k3, Object v3,
                                             String k4, Object v4) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return map;
    }

    public static HashMap<String, Object> of(String k1, Object v1, String k2, Object v2, String k3, Object v3,
                                             String k4, Object v4, String k5, Object v5) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return map;
    }

    public static HashMap<String, Object> of(String k1, Object v1, String k2, Object v2, String k3, Object v3,
                                             String k4, Object v4, String k5, Object v5, String k6, Object v6) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        return map;
    }

    public static HashMap<String, Object> of(String k1, Object v1, String k2, Object v2, String k3, Object v3,
                                             String k4, Object v4, String k5, Object v5, String k6, Object v6,
                                             String k7, Object v7) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        return map;
    }

    public static HashMap<String, Object> of(String k1, Object v1, String k2, Object v2, String k3, Object v3,
                                             String k4, Object v4, String k5, Object v5, String k6, Object v6,
                                             String k7, Object v7, String k8, Object v8) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        return map;
    }

    public static HashMap<String, Object> of(String k1, Object v1, String k2, Object v2, String k3, Object v3,
                                             String k4, Object v4, String k5, Object v5, String k6, Object v6,
                                             String k7, Object v7, String k8, Object v8, String k9, Object v9) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        return map;
    }

    public static HashMap<String, Object> of(String k1, Object v1, String k2, Object v2, String k3, Object v3,
                                             String k4, Object v4, String k5, Object v5, String k6, Object v6,
                                             String k7, Object v7, String k8, Object v8, String k9, Object v9,
                                             String k10, Object v10) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        return map;
    }


    //===============
    public static HashMap<String, String> stringOf(String k1, String v1) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(k1, v1);
        return map;
    }

    public static HashMap<String, String> stringOf(String k1, String v1, String k2, String v2) {
        HashMap<String, String> map =new HashMap<String, String>();
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    public static HashMap<String, String> stringOf(String k1, String v1, String k2, String v2, String k3, String v3) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return map;
    }

    public static HashMap<String, String> stringOf(String k1, String v1, String k2, String v2, String k3, String v3,
                                                   String k4, String v4) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return map;
    }

    public static HashMap<String, String> stringOf(String k1, String v1, String k2, String v2, String k3, String v3,
                                                   String k4, String v4, String k5, String v5) {
        HashMap<String, String> map =new HashMap<String, String>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return map;
    }

    //===============
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static HashMap rawOf() {
        HashMap map = new HashMap();
        return map;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static HashMap rawOf(Object k1, Object v1) {
        HashMap map = new HashMap();
        map.put(k1, v1);
        return map;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static HashMap rawOf(Object k1, Object v1, Object k2, Object v2) {
        HashMap map = new HashMap();
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static HashMap rawOf(Object k1, Object v1, Object k2, Object v2, Object k3, Object v3) {
        HashMap map = new HashMap();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return map;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static HashMap rawOf(Object k1, Object v1, Object k2, Object v2, Object k3, Object v3,
                                Object k4, Object v4) {
        HashMap map = new HashMap();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return map;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static HashMap rawOf(Object k1, Object v1, Object k2, Object v2, Object k3, Object v3,
                                Object k4, Object v4, Object k5, Object v5) {
        HashMap map = new HashMap();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return map;
    }
}
