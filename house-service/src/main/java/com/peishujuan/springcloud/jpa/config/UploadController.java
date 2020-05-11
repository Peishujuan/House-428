package com.peishujuan.springcloud.jpa.config;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @RequestMapping("/upload")
    public String upload(MultipartFile file) {
        try {
            //判断上传的文件
            if (file != null && !file.isEmpty()) {
                //上传地址
                String path = "F:\\pic\\";
                //重命名文件的名称
                String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
                //创建文件对象
                File destFile = new File(path, fileName);
                //当前文件进行拷贝
                file.transferTo(destFile);
                //返回图片的路径地址
                return "http://localhost:8184/img/" + fileName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回上传失败的值
        return "上传失败";
    }
}
