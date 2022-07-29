package com.alexandre.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.domain.Cliente;
import com.alexandre.repository.ClienteRepository;
import com.alexandre.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository ClienteRepository;
	
	public Cliente buscar(Integer id){
		return ClienteRepository.findById(id).orElseThrow(() -> 
			new ObjectNotFoundException("Objeto não encontrado: " + id +" Tipo: "+ Cliente.class.getName()));
	}
}
