package mesanalysis.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaohan
 */

@Data
public class Water implements Serializable {

    private static final long serialVersionUID = 7251655527158063389L;

    public Water(int o_id,String type,long total,int id){

        this.o_id=o_id;
        this.total=total;
        this.type=type;
        this.id=id;

    }

    /**
     * 订单id
     */
    private int o_id;
    /**
     * 机器id
     */
    private int id;
    /**
     * 酒水种类
     */
    private String type;
    /**
     * 酒水总量
     */
    private long total;
}

