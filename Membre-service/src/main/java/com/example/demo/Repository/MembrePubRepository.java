package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entites.Membre_Pub_Ids;
import com.example.demo.Entites.Membre_Publication;
@Repository
public interface MembrePubRepository extends JpaRepository<Membre_Publication, Membre_Pub_Ids> {
	@Query("select m from Membre_Publication m where auteur_id=:x")
	List<Membre_Publication> findpubId(@Param ("x") Long autId);

}
