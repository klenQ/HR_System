package com.klen.hrsys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/14
 */

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int number;
    @Column
    private String name;
    @Column
    private String gender;
    @Column
    private int age;
    @JsonIgnore
    @Column(updatable = false)
    @CreatedDate
    private Timestamp createTime;
    @JsonIgnore
    @Column
    @LastModifiedDate
    private Timestamp modifyTime;

    @ManyToOne
    @JoinColumn(name = "dep_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private Department dep;


}
