package com.example.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.Serializable;

/**
 * @author zhaohan
 * 企业注册类
 */

@Data
@Component
public class BusinessRegistration implements Serializable {

    private static final long serialVersionUID = 6653220084570534353L;

    /**
     * 企业法人
     */
    private String enterpriseLegalPerson;

    /**
     *客服电话
     */
    private int customerPhones;

    /**
     * 企业邮箱
     */
    private String businessEmail;

    /**
     * 仓库地址
     */
    private String warehouseAddress;

    /**
     *真实姓名
     */
    private String name;

    /**
     * 联系电话
     */
    private int phone;

    /**
     * 营业执照
     */
    private File businessLicense;

    /**
     * 流水线照片
     */
    private File assemblyLinePhotos;

}

