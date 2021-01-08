package com.example.demo.Entites;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("ens")

public class EnseignantChercheur extends Membre{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String Grade;
	private  String Etablissement ;
	@JsonIgnoreProperties("enseignantChercheur")
	@OneToMany(mappedBy = "enseignantChercheur")
	private Collection<Etudiant>etudiants;
	public EnseignantChercheur(Long id, String cin, String nom, String prenom, Date date, byte[] photo, String cv,
			String email, String password, String grade, String etablissement, Collection<Etudiant> etudiants) {
		super(id, cin, nom, prenom, date, photo, cv, email, password);
		Grade = grade;
		Etablissement = etablissement;
		this.etudiants = etudiants;
	}
	public EnseignantChercheur() {
		super();
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	public String getEtablissement() {
		return Etablissement;
	}
	public void setEtablissement(String etablissement) {
		Etablissement = etablissement;
	}
	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	

}
