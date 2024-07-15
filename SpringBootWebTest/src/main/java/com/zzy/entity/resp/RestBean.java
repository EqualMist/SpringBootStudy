package com.zzy.entity.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RestBean<T> {

    Integer code;
    String msg;
    T Data;

    public RestBean(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
