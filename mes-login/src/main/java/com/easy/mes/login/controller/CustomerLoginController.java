package com.easy.mes.login.controller;

import com.easy.commonutils.CommonResult;
import com.easy.commonutils.JwtConfig;
import com.easy.mes.login.entity.CustomerLogin;
import com.easy.mes.login.service.CustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-19
 */
@RestController
@CrossOrigin
@RequestMapping("/login/customer-login")
public class CustomerLoginController {
    @Autowired
    private CustomerLoginService customerLoginService;
    //登录
    @PostMapping("culogin")
    public CommonResult culogin(@RequestBody CustomerLogin customerLogin){
        String token =customerLoginService.culogin(customerLogin);
        return CommonResult.OK().data("cu_token",token);
    }

    //注册
    @PostMapping("curegister")
    public CommonResult curegister(@RequestBody CustomerLogin customerLogin){
        customerLoginService.curegister(customerLogin);
        return CommonResult.OK();
    }

    //根据token获取用户信息
    @GetMapping("getcuInfo")
    public CommonResult getcuInfo(HttpServletRequest request){
//        String id= JwtConfig.getIdByJwtToken(request);
        String id = JwtConfig.getIdByJwtToken(request);
        CustomerLogin byId = customerLoginService.getById(id);
        return CommonResult.OK().data("result",byId);
    }

    //根据用户id获取用户信息(远程调用方法)
    @GetMapping("getCuInfoById/{id}")
    public List<CustomerLogin> getCuInfoById(@PathVariable("id") Long id){
        return customerLoginService.getCuInfoById(id);
    }

}

