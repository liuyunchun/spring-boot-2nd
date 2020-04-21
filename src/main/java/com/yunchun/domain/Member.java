package com.yunchun.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "member")
public class Member {

    @Id
    @Column(name = "id_")
    private String id;

    @Column(name = "password_")
    private String password;

    @Column(name = "name_")
    private String name;

    @Column(name = "email_")
    private String email;

    @Column(name = "ban_time_")
    private LocalDate banTime;

    @ManyToOne
    @JoinColumn(name = "board_master_")
    private SysCode boardMaster;
}
