package com.yunchun.service.impl;

import com.yunchun.domain.SysCode;
import com.yunchun.repository.SysCodeRepository;
import com.yunchun.service.GenericService;
import com.yunchun.service.SysCodeService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Service("com.yunchun.service.impl.SysCodeServiceImpl")
public class SysCodeServiceImpl implements SysCodeService {
//    @PostConstruct
//    public void init() {
//        setR(sysCodeRepository);
//    }

    @Resource
    private SysCodeRepository sysCodeRepository;

//    @Override
//    public Object find(String id) {
//        return null;
//    }


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
    public List<SysCode> findAll() {
        return sysCodeRepository.findAll();
    }

    @Override
    public void delete(SysCode syscode){
        sysCodeRepository.delete(syscode);
    }
}
