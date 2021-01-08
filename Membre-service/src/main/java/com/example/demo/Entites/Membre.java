package com.example.demo.Entites;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.example.demo.beans.EventBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;

import lombok.Data;
import lombok.Getter;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",length = 3)
@Data
public abstract class Membre implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cin ;
	
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date date;
	private byte[]photo;
	private String cv;
	private String email;
	private String password;
	@Transient
	private List<PublicationBean> pubs;
	
	@Transient
	private List<EventBean>events;
	
	@Transient
	private List<OutilBean> outils;
	public Membre() {
		super();
	}
	public Membre(Long id, String cin, String nom, String prenom, Date date, byte[] photo, String cv, String email,
			String password) {
		super();
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.photo = photo;
		this.cv = cv;
		this.email = email;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cin == null) ? 0 : cin.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Membre other = (Membre) obj;
		if (cin == null) {
			if (other.cin != null)
				return false;
		} else if (!cin.equals(other.cin))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Membre [id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", date=" + date
				+ ", photo=" + Arrays.toString(photo) + ", cv=" + cv + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	
	
}
