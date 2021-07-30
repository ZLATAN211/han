package mesanalysis.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaohan
 */

@Data
public class Returns implements Serializable {

    private static final long serialVersionUID = 3251605867558063389L;

    /**
     * 机器的id号
     */
    private int id;

    /**
     * 机器的产能(每小时)
     */
    private int capacity;

}

