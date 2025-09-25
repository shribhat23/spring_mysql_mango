package com.pranav.GamingClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pranav.GamingClub.entities.Member;

@Repository
public interface MemberRepository  extends JpaRepository<Member, Integer> {
    Member findMemberByPhone(String phone);
}
