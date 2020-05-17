package com.yunchun.service;

import com.yunchun.domain.Member;
import com.yunchun.domain.SysCode;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class MemberServiceTest {
    @Resource
    private SysCodeService sysCodeService;

    @Resource
    private MemberService memberService;

    @Test
    public void testMember(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = LocalDate.parse("2020/05/18", formatter);

        SysCode syscode = new SysCode();
        syscode.setId("001");
        syscode.setCode("A");
        syscode.setDescription("版主");

        sysCodeService.insert(syscode);
        SysCode syscode2 = sysCodeService.find("001");

        Member member = new Member();
        member.setId("123");
        member.setPassword("456");
        member.setName("arashi");
        member.setEmail("123@mail");
        member.setBanTime(date);
        member.setBoardMaster(syscode2);

        memberService.insert(member);
        Member result = memberService.find("123");
        Assertions.assertThat(result).isNotNull();
        System.err.println(result);

        result.setName("arashi0920");
        result = memberService.update(result);
        Assertions.assertThat(result.getName()).isEqualTo("arashi0920");
        System.err.println(result);

        memberService.delete(result);
        result = memberService.find("123");
        Assertions.assertThat(result).isNull();

    }
}
