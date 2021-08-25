package com.easy.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  统一结果返回
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-08
 */

@Data
public class CommonResult {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    @ApiModelProperty(value = "返回值")
    private Integer code;
    @ApiModelProperty(value = "返回消息")
    private String message;
    @ApiModelProperty(value = "返回数据")
    private Map<String,Object> data=new HashMap<String,Object>();
    //锁定
    private CommonResult(){}
    //返回成功
    public static CommonResult OK(){
        CommonResult c =new CommonResult();
        c.setSuccess(true);
        c.setCode(ResultCode.SUCCESS);
        c.setMessage("成功");
        return c;
    }
    //返回失败
    public static CommonResult error(){
        CommonResult c =new CommonResult();
        c.setSuccess(false);
        c.setCode(ResultCode.ERROR);
        c.setMessage("失败");
        return c;
    }

    public CommonResult success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public CommonResult code(Integer code){
        this.setCode(code);
        return this;
    }

    public CommonResult message(String message){
        this.setMessage(message);
        return this;
    }

    public CommonResult date(Map<String,Object> map){
        this.setData(map);
        return this;
    }

    public CommonResult data(String key,Object value){
        this.data.put(key,value);
        return this;
    }
}
