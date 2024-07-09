package com.zzy.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Accessors(chain = true)
public class Account implements Serializable {
    int id;
    String username;
    String password;
    String role;
}
