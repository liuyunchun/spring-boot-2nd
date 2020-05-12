package com.yunchun.service;

import com.yunchun.domain.SysCode;

import java.util.List;

public interface SysCodeService{
    //extends GenericService<SysCode>

    SysCode insert (SysCode syscode);

    SysCode update (SysCode syscode);

    SysCode find (String id);

    List<SysCode> findAll ();

    void delete (SysCode syscode);
}
