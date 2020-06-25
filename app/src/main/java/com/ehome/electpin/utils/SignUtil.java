package com.ehome.electpin.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SignUtil {
    public static String getSign(Map<String, Object> map) {
        String str = "";
        List<Object> list = new ArrayList<Object>();
        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            Object value = map.get(key);
            list.add(key + "=" + value);
        }

        int leng = list.size() - 1;
        for (int i = 0; i < leng; i++) {
            str += list.get(i) + "&";
        }
        str += list.get(leng) + "|" + AppUtil.API_SAFE_KEY; //待签名字符串
        return Md5Util.MD5(str).toLowerCase();
    }
}
