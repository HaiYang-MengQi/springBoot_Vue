package com.codeCart.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.PutObjectRequest;
import com.codeCart.listener.PutObjectProgressListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;
@Component
@Scope("singleton")
public class FileUploadUtils {
    //todo 我想要实现在utils类中upload为静态方法,同时通过@Value进行注入
    //todo upload是静态,那么直接调用省去了实例化
    //todo @Value使用可以避免一旦地址变动多次繁琐的修改代码
    //todo 但是现在不行,upload是静态,实例方法属性值无法注入
    //todo upload不是静态目前可以运行,我现在采用的是实例化,以后接触到更厉害的人学一学之后准备抛弃这种方法
    @Value("${oss.bucketName}")
    private String bucketName;
    @Value("${oss.endpoint}")
    private String endpoint;
    public String upload(MultipartFile file) throws Exception{
        String objectName = UUID.randomUUID().
                toString()+file.getOriginalFilename()
                .substring(file.getOriginalFilename().lastIndexOf("."));
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
        try {
            //fixme 这是一个很蠢的方式,消耗磁盘io,我迟早要找到更好的办法将MultipartFile转换成File对象
            //fixme 而且这是运行在linux里面的,哪来的D盘
            file.transferTo(new File("D:\\"+objectName));
            ossClient.putObject(new PutObjectRequest(bucketName,objectName,new File("D:\\"+objectName)).
                    <PutObjectRequest>withProgressListener(new PutObjectProgressListener())
            );
            //fixme 这个是临时的,我得找到更好的办法
            File file1 = new File("D:\\" + objectName);
            if(file1.exists())
                file1.delete();
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    return "https://"+bucketName+".oss-cn-qingdao.aliyuncs.com/"+objectName;
    }

}
