package com.tinhpt.order.utils;

import java.text.Normalizer;

public class StringUtils {
    public static String removeAccent(String inputString) {
        String noneWhiteSpaceString = org.apache.commons.lang.StringUtils.deleteWhitespace(inputString);
        return Normalizer
                .normalize(noneWhiteSpaceString, Normalizer.Form.NFD)
                .replaceAll("đ", "d").replaceAll("Đ", "D")
                .replaceAll("[^\\p{ASCII}]", "");
    }
}
