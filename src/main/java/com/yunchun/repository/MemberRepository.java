package com.yunchun.repository;

import com.yunchun.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository("com.yunchun.repository.MemberRepository")
public interface MemberRepository extends JpaRepository <Member, String>{

    Member findOneById(String id);

    List<Member> findAllById(String id);

    @Query(
            "SELECT t FROM Member t " +
                    "WHERE t.name like :#{#member.name} " +
                    "ORDER BY t.id ASC"
    )
    List<Member> findAllByName(@Param("member") Member member);

    @Query(
            "SELECT t FROM Member t " +
                    "WHERE t.email like :#{#member.email} " +
                    "ORDER BY t.id ASC"
    )
    List<Member> findAllByEmail(@Param("member") Member member);

    @Query(
            "SELECT t FROM Member t " +
                    "WHERE t.id= :#{#member.id} " +
                    "AND t.name like :#{#member.name} " +
                    "ORDER BY t.id ASC"
    )
    List<Member> findAllByIdAndName(@Param("member") Member member);

    @Query(
            "SELECT t FROM Member t " +
                    "WHERE t.id= :#{#member.id} " +
                    "AND t.email like :#{#member.email} " +
                    "ORDER BY t.id ASC"
    )
    List<Member> findAllByIdAndEmail(@Param("member") Member member);

    @Query(
            "SELECT t FROM Member t " +
                    "WHERE t.name like :#{#member.name} " +
                    "AND t.email like :#{#member.email} " +
                    "ORDER BY t.id ASC"
    )
    List<Member> findAllByNameAndEmail(@Param("member") Member member);

    @Query(
            "SELECT t FROM Member t " +
                    "WHERE t.id= :#{#member.id} " +
                    "AND t.name like :#{#member.name} " +
                    "AND t.email like :#{#member.email} " +
                    "ORDER BY t.id ASC"
    )
    List<Member> findAllById_Name_Email(@Param("member") Member member);
}
