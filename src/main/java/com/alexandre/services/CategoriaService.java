package com.alexandre.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.domain.Categoria;
import com.alexandre.repository.CategoriaRepository;
import com.alexandre.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id){
		return categoriaRepository.findById(id).orElseThrow(() -> 
			new ObjectNotFoundException("Objeto não encontrado: " + id +" Tipo: "+ Categoria.class.getName()));
	}
}
