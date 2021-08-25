package com.easy.mes.filesreceive.service;

import org.springframework.web.multipart.MultipartFile;
/**
 *<p>
 *   服务类
 *</p>
 * @author LiZiHan
 * @since 2021-02-14
 */
public interface FRService {

    String uploadFile(MultipartFile file);

}
