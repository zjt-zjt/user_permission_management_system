package com.lanou.upms.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class Data<T> {

    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;
}
