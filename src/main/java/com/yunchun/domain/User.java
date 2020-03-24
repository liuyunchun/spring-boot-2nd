package com.yunchun.domain;

import lombok.Data;
import java.time.LocalDate;

@Data
public class User {

    private String id;

    private String password;

    private String name;

    private String email;
}
