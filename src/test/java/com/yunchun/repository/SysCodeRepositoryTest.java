package com.yunchun.repository;

import com.yunchun.domain.SysCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class SysCodeRepositoryTest {
    @Resource
    private SysCodeRepository sysCodeRepository;

    @Test
    public void test(){
        SysCode syscode = new SysCode();
        syscode.setId("001");
        syscode.setCode("A");
        syscode.setDescription("文章");

        //儲存
        sysCodeRepository.save(syscode);
        System.out.println(sysCodeRepository.findAll());

        //查詢
        SysCode syscode2 = sysCodeRepository.findOneByCode("A");

        //修改
        syscode2.setDescription("留言");
        sysCodeRepository.save(syscode2);
        System.out.println(sysCodeRepository.findAll());

        //刪除
        sysCodeRepository.delete(syscode2);
        System.out.println(sysCodeRepository.findAll());
    }


}
