package com.zzy.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "account_score")
public class Score {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;

    @OneToOne   //一对一对应到学科上
    @JoinColumn(name = "cid")
    Subject subject;

    @Column(name = "score")
    double score;

    @Column(name = "uid")
    int uid;

}
