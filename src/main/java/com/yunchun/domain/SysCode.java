package com.yunchun.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "sys_code")
public class SysCode {

    @Id
    @Column(name = "id_")
    private String id;

    @Column(name = "code_")
    private String code;

    @Column(name = "description_")
    private String description;
}
