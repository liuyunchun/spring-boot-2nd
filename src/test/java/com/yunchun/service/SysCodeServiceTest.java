package com.yunchun.service;

import com.yunchun.domain.SysCode;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class SysCodeServiceTest {
    @Resource
    private SysCodeService sysCodeService;

    @Test
    public void testSysCode() {
        SysCode syscode1 = new SysCode();
        syscode1.setId("001");
        syscode1.setCode("A");
        syscode1.setDescription("文章");

        sysCodeService.insert(syscode1);

        SysCode result = sysCodeService.find("001");
        Assertions.assertThat(result).isNotNull();
        System.err.println(result);

        result.setDescription("留言");
        result = sysCodeService.update(result);
        Assertions.assertThat(result.getDescription()).isEqualTo("留言");
        System.err.println(result);

        sysCodeService.delete(result);
        result = sysCodeService.find("001");
        Assertions.assertThat(result).isNull();
    }
}
