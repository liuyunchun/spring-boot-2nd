package com.yunchun.service.impl;

import com.yunchun.domain.SysCode;
import com.yunchun.repository.SysCodeRepository;
import com.yunchun.service.SysCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service("com.yunchun.service.impl.SysCodeServiceImpl")
public class SysCodeServiceImpl extends GenericServiceImpl<SysCode, SysCodeRepository> implements SysCodeService {

    @Resource
    private SysCodeRepository sysCodeRepository;

    @PostConstruct
    public void init() {
        setRepository(sysCodeRepository);
    }

    @Override
    public SysCode find(String id) {
        return sysCodeRepository.findOneById(id);
    }

}
