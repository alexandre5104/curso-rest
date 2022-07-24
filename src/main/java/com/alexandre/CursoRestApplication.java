package com.alexandre;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alexandre.domain.Categoria;
import com.alexandre.repository.CategoriaRepository;

@SpringBootApplication
public class CursoRestApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoRestApplication.class, args);
	}

	@Override	
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "papelaria");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
