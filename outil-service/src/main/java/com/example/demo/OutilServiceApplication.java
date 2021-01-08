package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.entites.Outil;
import com.example.demo.repository.OutilRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class OutilServiceApplication implements CommandLineRunner {
	@Autowired
	OutilRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(OutilServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Outil o =new Outil(new Long(0), null, "dource");
		repo.save(o);
		
	}

}
