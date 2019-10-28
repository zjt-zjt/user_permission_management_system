package com.lanou.upms.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 用于返回LayUI表格数据
 * {
 *   "code": 0,
 *   "msg": "",
 *   "count": 1000,
 *   "data": [{}, {}]
 * }
 */
@Getter
@Setter
@ToString
public class LayUITableData<T> {
    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;
}
