package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entites.EnseignantChercheur;
import com.example.demo.Entites.Etudiant;
import com.example.demo.Entites.Membre;
import com.example.demo.IService.IMembreService;

@RestController
public class MemberController {

	@Autowired
	IMembreService memberService;

	@GetMapping("/members")
	public List<Membre> getAll() {
		return memberService.findAll();
	}

	@GetMapping("members/{id}")
	public Membre findById(@PathVariable("id") Long id) {
		return memberService.findById(id);
	}

	@GetMapping("members/affecter/{idEtudiant}/{idEns}")
	public Membre Affecter(@PathVariable("idEtudiant") Long idEtudiant, @PathVariable("idEns") Long idEns) {
		return memberService.affecterEnseigant(idEtudiant, idEns);
	}

	@PostMapping("members/addEtudiant")
	public Membre addEtudiant(@RequestBody Etudiant e) {
		return memberService.add(e);
	}

	@PostMapping("members/addEnseigant")
	public Membre addEnseigant(@RequestBody EnseignantChercheur e) {
		System.out.println("hi");
		System.out.println(e);
		return memberService.add(e);
	}

	@DeleteMapping("members/{id}")
	public void delete(@PathVariable("id") Long id) {
		Membre m = memberService.findById(id);
		memberService.delete(m);
	}

	@PutMapping(value = "/membres/etudiant/{id}")

	public Membre updatemembre(@PathVariable Long id, @RequestBody Etudiant p)

	{

		p.setId(id);
		return memberService.update(p);

	}

	@PutMapping(value = "/membres/enseignant/{id}")
	public Membre updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p)

	{

		p.setId(id);
		return memberService.update(p);

	}

	@GetMapping

	("/fullmember/{id}")

	public Membre findAFullMember(@PathVariable(name = "id") Long id)

	{

		Membre mbr = memberService.findById(id);

		mbr.setPubs(memberService.findPublicationparauteur(id));
		mbr.setEvents(memberService.findMemberEvents(id));
		mbr.setOutils(memberService.findMemberOutils(id));

		return mbr;

	}
	@GetMapping("/affecterPub/{idPub}/{idMem}")

	public void affecterPublication(@PathVariable(name = "idPub") Long idPub,@PathVariable(name = "idMem") Long idMem)

	{

		memberService.affecterauteurTopublication(idMem, idPub);

	}
	
	@GetMapping("/affecterEvent/{idEvent}/{idMem}")

	public void affecterEvent(@PathVariable(name = "idEvent") Long idEvent,@PathVariable(name = "idMem") Long idMem)

	{

		memberService.affecterEventToMember(idEvent, idMem);

	}
	
	@GetMapping("/affecterOutil/{idOutil}/{idMem}")

	public void affecterOutil(@PathVariable(name = "idOutil") Long idOutil,@PathVariable(name = "idMem") Long idMem)

	{

		memberService.affecterOutilToMember(idMem, idOutil);

	}
	
	

}
