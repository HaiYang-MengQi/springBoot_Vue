package com.codecart.util;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDataUtils {
    public static String getLocalTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return  LocalDateTime.now().format(formatter);
    }

}
