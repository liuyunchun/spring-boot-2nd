package com.yunchun.service;

import com.yunchun.domain.Member;
import com.yunchun.repository.MemberRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberService extends GenericService<Member, MemberRepository>{
    Member insert(Member member);

    Member update(Member member);

    Member find(String id);

    void delete(Member member);

    List<Member> findAllById(String id);

    List<Member> findAllByName(@Param("member") Member member);

    List<Member> findAllByEmail(@Param("member") Member member);

    List<Member> findAllByIdAndName(@Param("member") Member member);

    List<Member> findAllByIdAndEmail(@Param("member") Member member);

    List<Member> findAllByNameAndEmail(@Param("member") Member member);

    List<Member> findAllById_Name_Email(@Param("member") Member member);
}
