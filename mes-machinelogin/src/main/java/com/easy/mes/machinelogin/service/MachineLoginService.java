package com.easy.mes.machinelogin.service;

import com.easy.mes.machinelogin.entity.MaSet;
import com.easy.mes.machinelogin.entity.Machine;
import com.easy.mes.machinelogin.entity.StateFunction;
import com.easy.mes.machinelogin.mapper.MachineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;

/**
 * @author zhaohan
 * 注册机器服务
 */

@Service
public class MachineLoginService {

    @Autowired
    private MachineMapper machineMapper;

    public boolean loginMachine(Machine machine){

        boolean flag=false;

        MaSet maSet=machineMapper.findByM_id(machine.getM_id());
        if (maSet==null){
            LinkedList<StateFunction> set=machine.getState();
            for (int i=0;i<machine.getState().size();i++){
                StateFunction function=set.get(i);
                machineMapper.insertFunction(function);
            }
            machineMapper.insertMachine(machine);
            flag=true;
        }

        return flag;

    }

}

