package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entites.Membre;
@Repository

public interface MembreRepository extends JpaRepository<Membre,Long> {

}
