package com.example.demo.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {

}
