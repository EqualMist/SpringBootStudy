package com.zzy.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class Student {
    private Integer sid;
    private String name;
    private String sex;

}
