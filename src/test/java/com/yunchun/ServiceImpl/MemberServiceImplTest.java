package com.yunchun.ServiceImpl;

import com.yunchun.domain.Member;
import com.yunchun.domain.SysCode;
import com.yunchun.service.impl.MemberServiceImpl;
import com.yunchun.service.impl.SysCodeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberServiceImplTest {
    @Resource
    private SysCodeServiceImpl sysCodeServiceImpl;

    @Resource
    private MemberServiceImpl memberServiceImpl;

    @Test
    public void test(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = LocalDate.parse("2020/05/07", formatter);

        SysCode syscode = new SysCode();
        syscode.setId("001");
        syscode.setCode("A");
        syscode.setDescription("版主");

        sysCodeServiceImpl.insert(syscode);

        Member member1 = new Member();
        member1.setId("123");
        member1.setPassword("456");
        member1.setName("arashi");
        member1.setEmail("123@mail");
        member1.setBanTime(date);
        member1.setBoardMaster(syscode);

        memberServiceImpl.insert(member1);

    }
}
