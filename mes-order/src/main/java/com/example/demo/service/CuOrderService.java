package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.CuOrder;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-21
 */
public interface CuOrderService extends IService<CuOrder> {

    String createCuOrder(Long pId, String idByJwtToken);

}
