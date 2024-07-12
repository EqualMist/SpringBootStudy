package com.zzy.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@Accessors(chain = true)
@Entity
@Table(name = "account")
public class Account implements Serializable {
    @Column(name = "id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Id
    int id;
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;
    @Column(name = "role")
    String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    AccountDetail detail;

    @JoinColumn(name = "uid")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    List<Score> scoreList;
}
