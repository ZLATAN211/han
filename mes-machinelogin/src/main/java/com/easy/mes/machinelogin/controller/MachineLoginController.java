package com.easy.mes.machinelogin.controller;

import com.easy.commonutils.CommonResult;
import com.easy.mes.machinelogin.entity.MaSet;
import com.easy.mes.machinelogin.entity.Machine;
import com.easy.mes.machinelogin.mapper.MachineMapper;
import com.easy.mes.machinelogin.service.MachineLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhaohan
 */

@Controller
public class MachineLoginController {

    @Autowired
    private MachineLoginService machLoginService;

    @Autowired
    private MachineMapper machineMapper;

    @RequestMapping(value = "/machinelogin",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult mLogin(@RequestBody Machine machine){

        String tate;

        if (machLoginService.loginMachine(machine)){
            tate="注册成功";
            return CommonResult.OK().message(tate);
        }else {
            tate="注册失败";
            return CommonResult.error().message(tate);
        }

    }

    @RequestMapping(value = "/machineSearch",method = RequestMethod.POST)
    @ResponseBody
    public String mSearch(@RequestBody int m_id){

        MaSet maSet=machineMapper.findByM_id(m_id);
        String json=(String) JSON.toJSON(maSet);
        return json;

    }

    @RequestMapping(value = "/machineDelete",method = RequestMethod.POST)
    @ResponseBody
    public void mDelete(@RequestBody int m_id){

        machineMapper.deleteBym_id(m_id);

    }

}

