package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entites.OutilMember;
import com.example.demo.Entites.OutilMemberId;


public interface OutilMemebrRepository extends JpaRepository<OutilMember, OutilMemberId> {
	@Query("select o from OutilMember  o where o.id.memberId=:x")
	List<OutilMember> findoutilId(@Param ("x") Long autId); 
}


