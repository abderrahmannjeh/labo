package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.Outil;

@Repository
public interface OutilRepository extends JpaRepository<Outil, Long> {

}
