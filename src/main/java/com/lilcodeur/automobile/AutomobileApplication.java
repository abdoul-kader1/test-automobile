package com.lilcodeur.automobile;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class AutomobileApplication implements CommandLineRunner {

	public static void main(String[] args) {SpringApplication.run(AutomobileApplication.class, args);}

	@Override
	public void run(String... args) {
		//log.info("Le resultat de l'operation est : ");
	}
}
