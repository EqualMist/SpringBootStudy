package com.zzy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Accessors(chain = true)
public class UserData implements Serializable {

    private Integer id;
    private String name;
    private String password;
    private String role;
    private String email;
}
