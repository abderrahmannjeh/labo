package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entites.EventMember;
import com.example.demo.Entites.EventMemberId;

@Repository 
public interface EventMemberRepository extends JpaRepository<EventMember, EventMemberId> {
	@Query("select em from EventMember em where em.id.memberId=:id" )
	List<EventMember> findwithMemberId(@Param("id")Long memberId);

}
