package com.codeCart.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeUtils {
    public static String getLocalTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return  LocalDateTime.now().format(formatter);
    }

}
