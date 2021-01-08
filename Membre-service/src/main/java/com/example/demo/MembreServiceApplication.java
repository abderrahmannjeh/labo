package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.Entites.EnseignantChercheur;
import com.example.demo.Entites.Etudiant;
import com.example.demo.IService.IMembreService;
import com.example.demo.beans.PublicationBean;
import com.example.demo.proxy.PublicationProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MembreServiceApplication implements CommandLineRunner {

	/*@Autowired
	private IMembreService membreService;
	@Autowired
	private PublicationProxy publicationProxy;*/
	public static void main(String[] args) {
		SpringApplication.run(MembreServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	/*	Etudiant e1=new Etudiant(null, "45", "e1", "e1", null, null, "c:\\cv", "etud1@gmail.com", "123", null, "ing");
		membreService.add(e1);
		EnseignantChercheur ens = new EnseignantChercheur(null, "787", "dsds", "zez", null, null, "ezez", "ens@gmail.com", "7878", "grad", "klk", null);
		ens = (EnseignantChercheur) membreService.add(ens);
		membreService.affecterEnseigant(e1.getId(), ens.getId());
		
		PublicationBean p =publicationProxy.recupererUnePublication(1L);
		System.out.println(p);*/
		
		
	}

}
