package com.codeCart.controller;

import com.aliyun.oss.model.OSSObject;
import com.codeCart.pojo.Result;
import com.codeCart.service.UserInfoService;
import com.codeCart.util.FileDeleteUtils;
import com.codeCart.util.FileDownloadUtils;
import com.codeCart.util.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    UserInfoService userInfoService;
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
        userInfoService.updateUserInfoAvatar(url);
        return Result.success(url);
    }
    //fixme 下载进度条可以,下载文档不报错,下载图片等其他文件老是爆:Premature end of Content-Length delimited message body (expected: 893,392; received: 3,592)
    @PostMapping("/download")
    public InputStream download(String objectName) throws Exception {
        OSSObject oss = fileDownloadUtils.download(objectName);
        return oss.getObjectContent();
    }
    @DeleteMapping("/delete")
    public Result<String> delete(String objectName) throws Exception {
        System.out.println(objectName);
        fileDeleteUtils.delete(objectName);
        return Result.success("删除成功");
    }
}
