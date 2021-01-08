package com.example.demo.Entites;

import java.util.Arrays;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@DiscriminatorValue("etd")

public class Etudiant extends Membre {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date dateInscription;
	private String diplome;
	@ManyToOne
	@JsonIgnoreProperties("etudiants")
	private EnseignantChercheur enseignantChercheur;
	
	public Etudiant() {
		super();
	}
	public Etudiant(Long id, String cin, String nom, String prenom, Date date, byte[] photo, String cv, String email,
			String password, Date dateInscription, String diplome) {
		super(id, cin, nom, prenom, date, photo, cv, email, password);
		this.dateInscription = dateInscription;
		this.diplome = diplome;
	}
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	@Override
	public String toString() {
		return "Etudiant [dateInscription=" + dateInscription + ", diplome=" + diplome + ", getId()=" + getId()
				+ ", getCin()=" + getCin() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getDate()="
				+ getDate() + ", getPhoto()=" + Arrays.toString(getPhoto()) + ", getCv()=" + getCv() + ", getEmail()="
				+ getEmail() + ", getPassword()=" + getPassword() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}
	public EnseignantChercheur getEnseignantChercheur() {
		return enseignantChercheur;
	}
	public void setEnseignantChercheur(EnseignantChercheur enseignantChercheur) {
		this.enseignantChercheur = enseignantChercheur;
	}
	
	
	
	

}
