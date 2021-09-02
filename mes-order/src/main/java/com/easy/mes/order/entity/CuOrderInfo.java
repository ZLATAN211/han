package com.easy.mes.order.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cu_order_info")
@ApiModel(value="CuOrderInfo对象", description="")
public class CuOrderInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 公司id
     */
    private Long coId;
    /**
     * 公司名
     */
    private String coName;
    /**
     * 客服部电话
     */
    private String csdTel;
    /**
     * 商品id
     */
    private Long pId;
    /**
     * 商品图片存储地址
     */
    private String pAddr;
    /**
     * 型号选择
     */
    private String pTypeChoose;
    /**
     * 产品形态
     */
    private String ptype;
    /**
     * 包装方式
     */
    private String packMethod;
    /**
     * 包装规格
     */
    private String packSp;
    /**
     * 用料方式
     */
    private Integer materialUsage;
    /**
     * 商品购买数量
     */
    private Long totalQuantity;
    /**
     * 商品总金额
     */
    private BigDecimal totalAmount;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
