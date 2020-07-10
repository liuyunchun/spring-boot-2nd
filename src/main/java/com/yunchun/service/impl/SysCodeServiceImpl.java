package com.yunchun.service.impl;

import com.yunchun.domain.SysCode;
import com.yunchun.repository.SysCodeRepository;
import com.yunchun.service.SysCodeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("com.yunchun.service.impl.SysCodeServiceImpl")
public class SysCodeServiceImpl extends GenericServiceImpl<SysCode, SysCodeRepository> implements SysCodeService {

//    @Resource
//    private SysCodeRepository sysCodeRepository;
//
//    @PostConstruct
//    public void init() {
//        setRepository(sysCodeRepository);
//    }

    @Override
    public SysCode find(String id) {
        return getRepository().findOneById(id);
    }

    @Override
    public Page<SysCode> getPagedSysCodes(int page, int size) {
        Page<SysCode> pageResult = getRepository().findAll(
                PageRequest.of(page,  // 查詢的頁數，從0起算
                        size, // 查詢的每頁筆數
                        Sort.by("id_").ascending())); //依id_欄位降冪排序
//        pageResult.getNumberOfElements(); // 本頁筆數
//        pageResult.getSize();             // 每頁筆數
//        pageResult.getTotalElements();    // 全部筆數
//        pageResult.getTotalPages();       // 全部頁數
//        List<SysCode> messageList = pageResult.getContent();

        return pageResult;
    }

    @Override
    public List<SysCode> findByIdAndCode(SysCode syscode) {
        return getRepository().findByIdAndCode(syscode);
    }

    @Override
    public List<SysCode> findAllById(String id) {
        return getRepository().findAllById(id);
    }

    @Override
    public List<SysCode> findAllByCode(String code) {
        return getRepository().findAllByCode(code);
    }

}
