package com.example.demo.IService;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.demo.Entites.Membre;
import com.example.demo.beans.EventBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;

@Service
public interface IMembreService {

	Membre add(Membre membre);

	Membre update(Membre membre);

	void delete(Membre membre);

	List<Membre> findAll();

	Membre affecterEnseigant(Long idEtudiant, Long idEns);

	Membre findById(Long id);

	 void affecterauteurTopublication(Long idauteur, Long idpub);

	 List<PublicationBean> findPublicationparauteur(Long idauteur);
	 
	 void affecterEventToMember(Long idEvent , Long idMember);
	 List<EventBean> findMemberEvents(Long idMember);
	 
	 void affecterOutilToMember(Long idOutil , Long idMember);
	 List<OutilBean> findMemberOutils(Long idMember);

}
