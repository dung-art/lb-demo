package com.example.demo.util;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtil {
  public static String removeAccents(String value) {
    if (value == null) {
      return null;
    }
    value = value.replace("Đ", "D").replace("đ", "d");
    String temp = Normalizer.normalize(value, Normalizer.Form.NFD);
    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    return pattern.matcher(temp).replaceAll("");
  }

  public static String keepAlphaNumberic(String value) {
    if (value == null) {
      return null;
    }
    return value.replaceAll("[^A-Za-z0-9]", "");
  }

  public static String keepAlphaNumbericNewLine(String value) {
    if (value == null) {
      return null;
    }
    return value.replaceAll("[^A-Za-z0-9\\n]", "");
  }
  
  public static String toFullTextSearch(String value) {
    if (value == null) {
      return null;
    }
    return keepAlphaNumbericNewLine(removeAccents(value.toLowerCase()));
  }
}
