package com.example.demo.controller;


import com.example.demo.entity.BusinessRegistration;
import com.example.demo.handler.VerificationHandler;
import com.example.demo.service.ApiInterfaceGetter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import java.io.*;

/**
 * @author zhaohan
 * 验证的controller
 */

@Controller
public class VerificationController {

    @RequestMapping(value = "/confirm",method = RequestMethod.POST)
    @ResponseBody
    public boolean search(@RequestBody BusinessRegistration business) throws IOException {

        String name=business.getEnterpriseLegalPerson();
        String token = "您的token";
        String url = "http://open.api.tianyancha.com/services/open/ic/baseinfo/2.0?keyword="+name;
        String json= ApiInterfaceGetter.executeGet(url,token);
        boolean tate= VerificationHandler.verification(json,business);
        return tate;

    }

}

