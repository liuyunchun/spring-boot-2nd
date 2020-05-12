package com.yunchun.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @Column(name = "create_time_")
    private LocalDateTime createTime;

    //OneToMany
    @OneToMany(mappedBy = "id")
    private List<Member> articles;
}
