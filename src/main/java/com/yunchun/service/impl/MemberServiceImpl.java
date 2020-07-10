package com.yunchun.service.impl;

import com.yunchun.domain.Member;
import com.yunchun.repository.MemberRepository;
import com.yunchun.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Service("com.yunchun.service.impl.MemberServiceImpl")
public class MemberServiceImpl extends GenericServiceImpl<Member, MemberRepository> implements MemberService{

//    @Resource
//    private MemberRepository memberRepository;
//
//    @PostConstruct
//    public void init(){setRepository(memberRepository);}

    @Override
    public Member find(String id) {
        return getRepository().findOneById(id);
    }

    @Override
    public List<Member> findAllById(String id) {
        return getRepository().findAllById(id);
    }

    @Override
    public List<Member> findAllByName(Member member) {
        return getRepository().findAllByName(member);
    }

    @Override
    public List<Member> findAllByEmail(Member member) {
        return getRepository().findAllByEmail(member);
    }

    @Override
    public List<Member> findAllByIdAndName(Member member) {
        return getRepository().findAllByIdAndName(member);
    }

    @Override
    public List<Member> findAllByIdAndEmail(Member member) {
        return getRepository().findAllByIdAndEmail(member);
    }

    @Override
    public List<Member> findAllByNameAndEmail(Member member) {
        return getRepository().findAllByNameAndEmail(member);
    }

    @Override
    public List<Member> findAllById_Name_Email(Member member) {
        return getRepository().findAllById_Name_Email(member);
    }
}
