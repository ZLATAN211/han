package mesanalysis.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhaohan
 */

@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 6251615847558162389L;

    /**
     * 商品名称(需要)
     */
    private String c_Name;
    /**
     * 预计生产时间
     */
    private int productionTime;
    /**
     * 订单id(需要)
     */
    private int o_id;
    /**
     * 创建时间
     */
    private Date c_time;
    /**
     * 用户名称(需要)
     */
    private String u_name;
    /**
     * 总额(需要)
     */
    private int t_amount;
    /**
     * 订单状态(需要)
     */
    private int state;
    /**
     * 配送方式(需要)
     */
    private String d_method;
    /**
     * 收货人姓名(需要)
     */
    private String r_name;

    /**
     * 收货人电话(需要)
     */
    private String r_phone;
    /**
     * 支付时间
     */
    private Date p_time;
    /**
     * 发货时间
     */
    private Date d_time;
    /**
     * 确认收货时间
     */
    private Date r_time;
    /**
     * 订单备注(需要)
     */
    private String remark;
    /**
     * 客服电话
     */
    private String cs_phone;
    /**
     * 规格
     */
    private int specifications;
    /**
     * 运输地址
     */
    private String address;
    /**
     * 商品销售属性组合(json)
     */
    private String s_vals;

}
