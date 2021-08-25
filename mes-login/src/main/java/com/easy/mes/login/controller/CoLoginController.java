package com.easy.mes.login.controller;

import com.easy.commonutils.CommonResult;
import com.easy.commonutils.JwtConfig;
import com.easy.mes.login.entity.CoLogin;
import com.easy.mes.login.service.CoLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-17
 */
@RestController
@CrossOrigin
@RequestMapping("/login/co-login")
public class CoLoginController {
    @Autowired
    private CoLoginService coLoginService;
    //登录
    @PostMapping("cologin")
    public CommonResult login(@RequestBody CoLogin coLogin){
        String token=coLoginService.login(coLogin);
        return CommonResult.OK().data("token",token);
    }
    //注册
    @PostMapping("coregister")
    public CommonResult register(@RequestBody CoLogin coLogin){
        coLoginService.register(coLogin);
        return CommonResult.OK();
    }
    //根据token获取用户信息
    @GetMapping("getcoInfo")
    public CommonResult getcoInfo(HttpServletRequest request){
        String idByJwtToken = JwtConfig.getIdByJwtToken(request);
        CoLogin byId = coLoginService.getById(idByJwtToken);
        return CommonResult.OK().data("result",byId);
    }
}

