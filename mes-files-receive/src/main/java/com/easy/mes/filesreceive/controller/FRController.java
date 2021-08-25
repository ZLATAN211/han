package com.easy.mes.filesreceive.controller;

import com.easy.commonutils.CommonResult;
import com.easy.mes.filesreceive.service.FRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 *<p>
 *     控制器
 *</p>
 * @author LiZiHan
 * @since 2021-02-14
 */
@RestController
@CrossOrigin
@RequestMapping("/coFilesReceive/FR")
public class FRController {
    @Autowired
    private FRService frService;
    @PostMapping
    public CommonResult coFilesReceive(@RequestBody MultipartFile file){
        String url = frService.uploadFile(file);
        return CommonResult.OK().data("url",url);
    }
}
