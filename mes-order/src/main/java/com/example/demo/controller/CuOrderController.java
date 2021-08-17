package com.example.demo.controller;


import com.example.demo.entity.CuOrder;
import com.example.demo.service.CuOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-21
 */
@RestController
@CrossOrigin
@RequestMapping("/order/cu-order")
public class CuOrderController {
    @Autowired
    private CuOrderService cuOrderService;

    //生成订单,返回订单号
    @PostMapping("createCuOrder/{pId}")
    public commonResult createCuOrder(@PathVariable Long pId ,
                                      HttpServletRequest request){
        //根据token确认用户信息

        String orderId=cuOrderService.createCuOrder(pId,JwtConfig.getIdByJwtToken(request));
        return commonResult.OK().data("orderId",orderId);
    }

    //根据订单号查询订单
    @GetMapping("getCuOrder/{orderId}")
    public commonResult getCuOrder(@PathVariable("orderId") Long orderId){
        QueryWrapper<CuOrder> wrapper=new QueryWrapper<>();
        wrapper.eq("order_id",orderId);
        CuOrder order = cuOrderService.getOne(wrapper);
        return commonResult.OK().data("result",order);
    }


}

