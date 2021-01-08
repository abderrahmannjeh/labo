package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entites.EnseignantChercheur;
import com.example.demo.Entites.Etudiant;
import com.example.demo.Entites.EventMember;
import com.example.demo.Entites.EventMemberId;
import com.example.demo.Entites.Membre;
import com.example.demo.Entites.Membre_Pub_Ids;
import com.example.demo.Entites.Membre_Publication;
import com.example.demo.Entites.OutilMember;
import com.example.demo.Entites.OutilMemberId;
import com.example.demo.IService.IMembreService;
import com.example.demo.Repository.EventMemberRepository;
import com.example.demo.Repository.MembrePubRepository;
import com.example.demo.Repository.MembreRepository;
import com.example.demo.Repository.OutilMemebrRepository;
import com.example.demo.beans.EventBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.proxy.EventProxy;
import com.example.demo.proxy.OutilProxy;
import com.example.demo.proxy.PublicationProxy;

@Service
public class MembreService implements IMembreService {

	@Autowired
	private MembreRepository membreRepository;
	@Autowired
	private MembrePubRepository membrepubrepository;
	@Autowired
	private EventMemberRepository eventmemberRepository;
	@Autowired
	private OutilMemebrRepository outilMemberRepository;

	@Autowired
	PublicationProxy proxy;
	@Autowired
	EventProxy eventProxy;
	@Autowired
	OutilProxy outilProxy;

	@Override
	public Membre add(Membre membre) {
		// TODO Auto-generated method stub
		return membreRepository.save(membre);
	}

	public void affecterauteurTopublication(Long idauteur, Long idpub) {
		Membre mbr = membreRepository.findById(idauteur).get();
		Membre_Publication mbs = new Membre_Publication();
		mbs.setAuteur(mbr);
		mbs.setId(new Membre_Pub_Ids(idpub, idauteur));
		membrepubrepository.save(mbs);
	}

	@Override
	public Membre update(Membre membre) {
		// TODO Auto-generated method stub
		return membreRepository.save(membre);
	}

	@Override
	public void delete(Membre membre) {

		membreRepository.delete(membre);
	}

	@Override
	public List<Membre> findAll() {
		return membreRepository.findAll();
	}

	@Override
	public Membre affecterEnseigant(Long idEtudiant, Long idEns) {
		Etudiant e = (Etudiant) membreRepository.findById(idEtudiant).get();
		EnseignantChercheur ens = (EnseignantChercheur) membreRepository.findById(idEns).get();
		e.setEnseignantChercheur(ens);
		return membreRepository.save(e);
	}

	@Override
	public Membre findById(Long id) {
		return membreRepository.findById(id).get();
	}

	@Override
	public List<PublicationBean> findPublicationparauteur(Long idauteur) {
		List<PublicationBean> pubs = new ArrayList<PublicationBean>();

		List<Membre_Publication> idpubs = membrepubrepository.findpubId(idauteur);

		idpubs.forEach(s -> {
			System.out.println(s);

			pubs.add(proxy.recupererUnePublication(s.getId().getPublication_id()));
		});
		return pubs;

	}

	@Override
	public void affecterEventToMember(Long idEvent, Long idMember) {

		EventMemberId id = new EventMemberId(idEvent, idMember);
		EventMember eventMmebr = new EventMember(id);
		eventmemberRepository.save(eventMmebr);

	}

	@Override
	public List<EventBean> findMemberEvents(Long idMember) {
		List<EventMember> eventsMember = eventmemberRepository.findwithMemberId(idMember);
		List<EventBean> events = new ArrayList<>();
		eventsMember.forEach(e -> {
			events.add(eventProxy.getEventById(e.getId().getEventId()));
		});
		return events;
	}

	@Override
	public void affecterOutilToMember(Long idOutil, Long idMember) {
		OutilMemberId id = new OutilMemberId(idOutil, idMember);
		OutilMember outilMember =new OutilMember(id);
		outilMemberRepository.save(outilMember);

	}

	@Override
	public List<OutilBean> findMemberOutils(Long idMember) {
		
		List<OutilBean> outils = new ArrayList<OutilBean>();
		List<OutilMember> memberOutils = outilMemberRepository.findoutilId(idMember);
		memberOutils.forEach(outilMember -> {
			outils.add(outilProxy.recupererUneOutil(outilMember.getId().getOutilId()));
			
		});
		return outils;
	}

}
