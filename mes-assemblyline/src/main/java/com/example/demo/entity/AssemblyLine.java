package com.example.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author zhaohan
 */

@Data
@Component
public class AssemblyLine implements Serializable {

    private static final long serialVersionUID = 7011469592514648556L;

    private String lineName;

    private ArrayList<String> lineMode;

}
