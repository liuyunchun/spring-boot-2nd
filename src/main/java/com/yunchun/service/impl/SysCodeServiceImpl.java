package com.yunchun.service.impl;

import com.yunchun.domain.SysCode;
import com.yunchun.repository.SysCodeRepository;
import com.yunchun.service.SysCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("com.yunchun.service.impl.SysCodeServiceImpl")
public class SysCodeServiceImpl implements SysCodeService{
    @Resource
    private SysCodeRepository sysCodeRepository;

    @Override
    public SysCode insert(SysCode syscode){
        return sysCodeRepository.save(syscode);
    }

    @Override
    public SysCode update(SysCode syscode){
        return sysCodeRepository.save(syscode);
    }

    @Override
    public SysCode find(String id){
        return sysCodeRepository.findOneById(id);
    }

    @Override
    public void delete(SysCode syscode){
        sysCodeRepository.delete(syscode);
    }
}
