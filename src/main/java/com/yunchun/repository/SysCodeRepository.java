package com.yunchun.repository;

import com.yunchun.domain.SysCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository("com.yunchun.repository.SysCodeRepository")
public interface SysCodeRepository extends JpaRepository <SysCode, String> {

    SysCode findOneByCode(String code);

}
