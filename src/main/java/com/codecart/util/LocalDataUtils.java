package com.codecart.util;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDataUtils {
    public static String getRegisterTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String REGISTER_TIME = LocalDateTime.now().format(formatter);
        return  LocalDateTime.now().format(formatter);
    }

}
