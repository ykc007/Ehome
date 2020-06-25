package com.ehome.electpin.utils;

import android.util.Log;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortUtil
{

    public static Map<String, Object> sortMapByKey(Map<String, Object> oriMap)
    {
        if (oriMap == null || oriMap.isEmpty())
        {

            return null;
        }

        Log.i("ooomap", oriMap.toString());
        Map<String, Object> sortedMap = new TreeMap<String, Object>(new Comparator<String>()
        {
            public int compare(String key1, String key2)
            {
                return key1.compareTo(key2);
            }
        });
        sortedMap.putAll(oriMap);
        Log.i("sortedMap", sortedMap.toString());
        return sortedMap;
    }


}
