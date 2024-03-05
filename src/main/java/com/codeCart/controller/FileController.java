package com.codeCart.controller;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.MultipartUpload;
import com.aliyun.oss.model.OSSObject;
import com.codeCart.pojo.Result;
import com.codeCart.service.UserService;
import com.codeCart.util.FileDeleteUtils;
import com.codeCart.util.FileDownloadUtils;
import com.codeCart.util.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    UserService service;
    //todo 以下实例类在它们的todo解决后就要全部删掉,不进行实例化
    @Autowired
    FileUploadUtils fileUploadUtils;
    @Autowired
    FileDownloadUtils fileDownloadUtils;
    @Autowired
    FileDeleteUtils fileDeleteUtils;
    //fixme 上传任意文件可以,但是进度条MultipartFile转File类型不能是创建File再删掉,需要优化
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        String url = fileUploadUtils.upload(file);
        service.updateAvatar(url);
        return Result.success(url);
    }
    //fixme 下载进度条可以,下载文档不报错,下载图片等其他文件老是爆:Premature end of Content-Length delimited message body (expected: 893,392; received: 3,592)
    @PostMapping("/download")
    public ResponseEntity<byte[]> download(String objectName) throws Exception {
        //todo 我迟早要把这么蠢的list删掉,放到utils类中去
        List<Object> list = fileDownloadUtils.download(objectName);
        BufferedInputStream bis = (BufferedInputStream) list.get(0);
        OSSObject ossObject = (OSSObject) list.get(1);
        try {
            // 读取BufferedInputStream中的内容到byte数组中
            byte[] content = bis.readAllBytes();
            // 设置响应头，指定文件类型和下载方式
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", objectName);
            // 返回响应实体，包含文件内容和响应头
            return new ResponseEntity<>(content, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            // 关闭输入流
            try {
                // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
                bis.close();
                // ossObject对象使用完毕后必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
                ossObject.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @DeleteMapping("/delete")
    public Result<String> delete(String objectName) throws Exception {
        System.out.println(objectName);
        fileDeleteUtils.delete(objectName);
        return Result.success("删除成功");
    }
}
