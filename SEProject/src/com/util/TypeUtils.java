package com.util;

import java.util.Hashtable;

/**
 * @author dgbttn
 */

public class TypeUtils {
    private static Hashtable<String, String> types = new Hashtable<String, String>() {
        {
            put("Số", "INT");
            put("Tự do", "VARCHAR");
        }
    };

    public static String getType(String type) {
        return types.get(type);
    }
}