package com.zzy.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@Accessors(chain = true)
@Entity
@Table(name = "accounts")
public class Account implements Serializable {
    @Column(name = "id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Id
    int id;
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;
}
