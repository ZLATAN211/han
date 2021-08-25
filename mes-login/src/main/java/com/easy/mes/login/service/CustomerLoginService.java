package com.easy.mes.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easy.mes.login.entity.CustomerLogin;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-19
 */
public interface CustomerLoginService extends IService<CustomerLogin> {

    String culogin(CustomerLogin customerLogin);

    void curegister(CustomerLogin customerLogin);

    List<CustomerLogin> getCuInfoById(Long id);
}
