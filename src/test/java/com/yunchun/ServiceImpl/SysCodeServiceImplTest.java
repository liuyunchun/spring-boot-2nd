package com.yunchun.ServiceImpl;

import com.yunchun.domain.SysCode;
import com.yunchun.service.impl.SysCodeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class SysCodeServiceImplTest {
    @Resource
    private SysCodeServiceImpl sysCodeServiceImpl;

    @Test
    public void test(){
        SysCode syscode1 = new SysCode();
        syscode1.setId("001");
        syscode1.setCode("A");
        syscode1.setDescription("文章");

        sysCodeServiceImpl.insert(syscode1);

        SysCode syscode2 = sysCodeServiceImpl.find("001");

        syscode2.setDescription("留言");
        sysCodeServiceImpl.update(syscode2);

        SysCode syscode3 = sysCodeServiceImpl.find("001");
        sysCodeServiceImpl.delete(syscode3);
    }
}
