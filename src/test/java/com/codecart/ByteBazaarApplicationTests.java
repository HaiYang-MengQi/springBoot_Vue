package com.codecart;


import jakarta.servlet.ServletContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootTest
class ByteBazaarApplicationTests {
    @Autowired
private ServletContext servletContext;
    @Test
    void contextLoads() throws Exception {
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String date = now.format(formatter);
//        System.out.println(date);


//        String path = servletContext.getRealPath("/");
//        System.out.println(path+ File.separator+"publicKey.txt");
//        File file = new File(path+ File.separator+"publicKey.txt");
//        File file1 = new File(path+ File.separator+"privateKey.txt");
//        if(!file.exists()){
//            file.createNewFile();
//        }
//        if(!file1.exists()){
//            file1.createNewFile();
//        }
//        FileOutputStream out = new FileOutputStream(file);
//        FileOutputStream out1 = new FileOutputStream(file1);
//        out.write(RsaUtils.generateKeyPair().getPublicKey().getBytes());
//        out1.write(RsaUtils.generateKeyPair().getPrivateKey().getBytes());
//        out.close();
//        out1.close();
//        String password = RsaUtils.encryptPasswordWithRSA("123456");
//        System.out.println("加密后"+password);
//        password = RsaUtils.decryptPasswordWithRSA(password);
//        System.out.println("解密后"+password);
//        String a = RsaUtils.encryptPasswordWithRSA("123456");
//        String b = RsaUtils.decryptPasswordWithRSA(a);
//        System.out.println(a+'\n'+b);
    }

}
