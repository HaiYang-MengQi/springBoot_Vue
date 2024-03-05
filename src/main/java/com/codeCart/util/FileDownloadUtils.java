package com.codeCart.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyuncs.exceptions.ClientException;
import com.codeCart.listener.GetObjectProgressListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class FileDownloadUtils {
    //todo 能读字符串不能读图片,和FileController这样写很蠢,但是其他我也没办法
    //confused bis和osObject要是放在download方法里,在return之前,再注释掉这两个的close方法就能读远程txt文件,图片不行
    //confused 要是采用下面这种方式33行就会出错,try直接进finally执行close方法,再return一个null
//    private static BufferedInputStream bis;
//    private static OSSObject ossObject;
    @Value("${oss.bucketName}")
    private String bucketName;
    @Value("${oss.endpoint}")
    private String endpoint;
    public List<Object> download(String objectName) throws Exception {
        String savePath = "D:\\"+objectName;
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
        try {
            // ossObject包含文件所在的存储空间名称、文件名称、文件元数据以及一个输入流。
            OSSObject ossObject = ossClient.getObject(bucketName, objectName);
            ossClient.getObject(new GetObjectRequest(bucketName, objectName).
                            <GetObjectRequest>withProgressListener(new GetObjectProgressListener()),
                    new File(savePath));
            BufferedInputStream bis = new BufferedInputStream(ossObject.getObjectContent());
            List<Object> list = new ArrayList<>();
            list.add(bis);
            list.add(ossObject);
            return list;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (Throwable ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return null;
    }
}
