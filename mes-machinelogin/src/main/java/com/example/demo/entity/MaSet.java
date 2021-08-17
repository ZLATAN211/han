package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaohan
 * 解耦machine和stateFunction
 */

@Data
public class MaSet implements Serializable {

    private static final long serialVersionUID = 4663857772509461207L;

    private int m_id;

    private String m_name;

    private boolean learn;

}

