package com.easy.mes.verification.controller;

import com.easy.commonutils.CommonResult;
import com.easy.mes.verification.entity.AssemblyLine;
import com.easy.mes.verification.service.AssemblyLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhaohan
 */

@Controller
public class AssemblyLineController {

    @Autowired
    private AssemblyLineService assemblyLineService;

    @RequestMapping(value = "/assemblyLinelogin",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult assemblyLineLogin(@RequestBody AssemblyLine assemblyLine){

        if (assemblyLineService.insertLine(assemblyLine)){
            return CommonResult.OK().message("注册成功");
        }else {
            return CommonResult.error().message("注册失败");
        }

    }

    @RequestMapping(value = "/assemblyLineSearch",method = RequestMethod.POST)
    @ResponseBody
    public String assemblyLineSearch(@RequestBody String linename){

        String json=assemblyLineService.searchLine(linename);
        return json;

    }

    @RequestMapping(value = "/assemblyLineUpdate",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult assemblyLineUpdate(@RequestBody String m_name,String name,String linename){

        boolean tate=assemblyLineService.updateLine(m_name,name,linename);
        if (tate){
            return CommonResult.OK().message("修改成功");
        }else {
            String json="修改失败";
            return CommonResult.OK().message(json);
        }

    }

    @RequestMapping(value = "/deleteLine",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteLine(@RequestBody String linename){

        boolean tate=assemblyLineService.deleteLine(linename);
        if (tate){
            String json="删除成功";
            return CommonResult.OK().message(json);
        }else {
            String json="删除失败";
            return CommonResult.OK().message(json);
        }

    }

    @RequestMapping(value = "/deleteLineMachine",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteLineMachine(@RequestBody String m_name){

        boolean tate=assemblyLineService.deleteMachine(m_name);
        if (tate){
            String json="删除成功";
            return CommonResult.OK().message(json);
        }else {
            String json="删除失败";
            return CommonResult.OK().message(json);
        }

    }

}

