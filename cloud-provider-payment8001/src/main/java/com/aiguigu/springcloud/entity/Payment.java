package com.aiguigu.springcloud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：Li Bin
 * @date ： 2021/8/15 18:57
 * @description：
 */
@Data
public class Payment implements Serializable {
    private Long id;
    private String serial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Payment() {
    }

    public Payment(Long id, String serial) {
        this.id = id;
        this.serial = serial;
    }
}
