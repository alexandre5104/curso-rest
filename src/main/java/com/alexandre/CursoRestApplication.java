package com.alexandre;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alexandre.domain.Categoria;
import com.alexandre.domain.Cidade;
import com.alexandre.domain.Cliente;
import com.alexandre.domain.Endereco;
import com.alexandre.domain.Estado;
import com.alexandre.domain.Produto;
import com.alexandre.domain.enums.TipoCliente;
import com.alexandre.repository.CategoriaRepository;
import com.alexandre.repository.CidadeRepository;
import com.alexandre.repository.ClienteRepository;
import com.alexandre.repository.EnderecoRepository;
import com.alexandre.repository.EstadoRepository;
import com.alexandre.repository.ProdutoRepository;

@SpringBootApplication
public class CursoRestApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoRestApplication.class, args);
	}

	@Override	
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria(null, "informatica");
		Categoria categoria2 = new Categoria(null, "papelaria");
		
		Produto produto1 = new Produto(null, "computador", 2000.00);
		Produto produto2 = new Produto(null, "impressora", 800.00);
		Produto produto3 = new Produto(null, "mouse", 80.00);
		
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));
		
		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		
		/*Estado e Cidade*/
		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "São Paulo");
		
		Cidade cidade1 = new Cidade(null, "Uberlandia", estado1);
		Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
		Cidade cidade3 = new Cidade(null, "Campinas", estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
		/*Cliente*/
		Cliente cliente1 = new Cliente(null, "Mario Silva",
				"mario@gmail.com", "3212154647", TipoCliente.PESSOAFISICA); 
		cliente1.getTelefones().addAll(Arrays.asList("32145698", "912364799"));
		
		Endereco endereco1 = new Endereco(null, "Rua 1", "51", 
				"", "São Bento", "1354544", cliente1, cidade1);
		
		Endereco endereco2 = new Endereco(null, "Rua 4", "53", 
				"", "h", "5465456", cliente1, cidade2);
		
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));	
		
		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));
	}

}
