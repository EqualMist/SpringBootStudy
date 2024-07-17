package com.zzy.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ApiModel(description = "响应实体封装类")
@Data
@Accessors(chain = true)
@Entity
@Table(name = "accounts")
public class Account implements Serializable {
    @ApiModelProperty("状态码")
    @Column(name = "id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Id
    int id;
    @ApiModelProperty("状态码描述")
    @Column(name = "username")
    String username;
    @ApiModelProperty("数据实体")
    @Column(name = "password")
    String password;
}
