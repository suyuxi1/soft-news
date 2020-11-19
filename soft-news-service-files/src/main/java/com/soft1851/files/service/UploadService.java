package com.soft1851.files.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Su
 * @className UploadService
 * @Description TODO
 * @Date 2020/11/19 14:22
 * @Version 1.0
 **/
public interface UploadService {

    /**
     *
     * @param file   文件
     * @param fileExtName 扩展
     * @return url
     * @throws Exception 异常
     */
    String uploadFdfs(MultipartFile file, String fileExtName) throws Exception;
}
