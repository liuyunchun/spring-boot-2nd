package com.yunchun.repository;

import com.yunchun.domain.SysCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository("com.yunchun.repository.SysCodeRepository")
public interface SysCodeRepository extends JpaRepository <SysCode, String> {

    SysCode findOneByCode(String code);

    SysCode findOneById(String id);

    List<SysCode> findAllById(String id);

    List<SysCode> findAllByCode(String code);

    @Query(
            "SELECT t FROM SysCode t " +
                    "WHERE t.id= :#{#syscode.id} " +
                    "AND t.code= :#{#syscode.code} " +
                    "ORDER BY t.id ASC"
    )
    List<SysCode> findByIdAndCode(@Param("syscode") SysCode syscode);
}
