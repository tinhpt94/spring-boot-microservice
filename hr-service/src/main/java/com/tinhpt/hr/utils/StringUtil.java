package com.tinhpt.hr.utils;

import org.apache.commons.lang.StringUtils;

import java.text.Normalizer;

public class StringUtil {
    public static String removeAccent(String inputString) {
        String noneWhiteSpaceString = StringUtils.deleteWhitespace(inputString);
        return Normalizer
                .normalize(noneWhiteSpaceString, Normalizer.Form.NFD)
                .replaceAll("đ", "d").replaceAll("Đ", "D")
                .replaceAll("[^\\p{ASCII}]", "");
    }
}
