package com.ktds.ggtest.repository;

import com.ktds.ggtest.domain.Member;
import com.ktds.ggtest.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
    Member findByMemberId(String memberId);

}