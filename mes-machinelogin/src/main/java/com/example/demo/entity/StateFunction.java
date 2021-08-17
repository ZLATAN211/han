package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaohan
 */

@Data
public class StateFunction implements Serializable {

    private static final long serialVersionUID = -3823268291511505620L;

    private int state;

    private String function;

    private int stateNum;

    private int m_id;

}

