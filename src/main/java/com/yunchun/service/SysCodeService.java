package com.yunchun.service;

import com.yunchun.domain.SysCode;

public interface SysCodeService {
    SysCode insert (SysCode syscode);

    SysCode update (SysCode syscode);

    SysCode find (String id);

    void delete (SysCode syscode);
}
