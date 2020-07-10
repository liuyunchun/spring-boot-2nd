package com.yunchun.service;

import com.yunchun.domain.SysCode;
import com.yunchun.repository.SysCodeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SysCodeService extends GenericService<SysCode, SysCodeRepository> {
    SysCode insert(SysCode syscode);

    SysCode update(SysCode syscode);

    SysCode find(String id);

    void delete(SysCode syscode);

    Page<SysCode> getPagedSysCodes(int page, int size);

    List<SysCode> findByIdAndCode(@Param("syscode") SysCode syscode);

    List<SysCode> findAllById(String id);

    List<SysCode> findAllByCode(String code);
}
