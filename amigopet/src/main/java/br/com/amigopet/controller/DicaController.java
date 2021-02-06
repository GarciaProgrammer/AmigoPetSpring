package br.com.amigopet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.amigopet.model.Dica;

import br.com.amigopet.repository.DicaRepository;

@CrossOrigin
@RestController
@RequestMapping("/dica")
public class DicaController {

	@Autowired
	DicaRepository dicaRepository;
	
	@RequestMapping("/cadastra")
	@PostMapping
	public void cadastraDica(String titulo, String descricao) {
		Dica dica = new Dica(titulo, descricao);
		dicaRepository.save(dica);
	}
	
	@RequestMapping("/visualiza")
	@PostMapping
	public Optional<Dica> visualizaDica(Long id) {
		return dicaRepository.findById(id);
	}
	
	@RequestMapping("/altera")
	@PostMapping
	public void alteraDica(Long id, String titulo, String descricao, Byte imagem) {
		Dica dica = new Dica(id, titulo, descricao, imagem);
		dicaRepository.save(dica);
		
	}

	@RequestMapping("/deleta")
	@PostMapping
	public void deletaDica(Long id) {
		dicaRepository.deleteById(id);
	}
	
	@GetMapping("/lista")
	public List<Dica> listaDicas() {
		List<Dica> dicas = dicaRepository.findAll();
		
		return dicas;
	}
}
