package com.easy.mes.machinelogin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * @author zhaohan
 */

@Data
public class Machine implements Serializable {

    private static final long serialVersionUID = -7760461038519255026L;

    private int m_id;

    private String m_name;

    private boolean learn;

    private LinkedList<StateFunction> state;
}
