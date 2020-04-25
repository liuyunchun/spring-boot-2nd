package com.yunchun.repository;

import com.yunchun.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository("com.yunchun.repository.MemberRepository")
public interface MemberRepository extends JpaRepository <Member, String>{

    Member findOneById(String id);
}
