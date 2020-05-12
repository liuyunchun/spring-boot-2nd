package com.yunchun.service;

import com.yunchun.domain.SysCode;
import com.yunchun.repository.SysCodeRepository;

public interface SysCodeService extends GenericService<SysCode, SysCodeRepository> {
    SysCode insert(SysCode syscode);

    SysCode update(SysCode syscode);

    SysCode find(String id);

    void delete(SysCode syscode);
}
