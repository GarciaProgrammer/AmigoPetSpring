package br.com.amigopet.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.amigopet.controller.form.AnimalForm;
import br.com.amigopet.controller.form.AtualizacaoAnimalForm;
import br.com.amigopet.dto.AnimalDto;
import br.com.amigopet.model.Animal;
import br.com.amigopet.model.Usuario;
import br.com.amigopet.repository.AnimalRepository;

@CrossOrigin
@RestController
@RequestMapping("/animal")
public class AnimalController {

	@Autowired
	AnimalRepository animalRepository;

	
	
//	@PostMapping("/cadastrar")
//	@Transactional
//	public void cadastrar(String nome, String tipo, String raca, int idade, String sexo, String descricao, Byte imagem,
//			Usuario usuario, String cidade, String estado) {
//		Animal animal = new Animal(nome, tipo, raca, idade, sexo, descricao, imagem, usuario, cidade, estado);
//		animalRepository.save(animal);
//	}
	
//	@PostMapping("/cadastrar")
//	@Transactional
//	public ResponseEntity<AnimalDto> cadastrar(@RequestBody AnimalForm form, UriComponentsBuilder uriBuilder) {
//		Animal animal = form.converter();
//		animalRepository.save(animal);
//		URI uri = uriBuilder.path("/cadastrar/{id}").buildAndExpand(animal.getId()).toUri();
//		return ResponseEntity.created(uri).body(new AnimalDto(animal));
//	}

	@GetMapping("/visualizar/{id}")
	public AnimalDto visualizar(@PathVariable Long id) {
		Animal animal = animalRepository.getOne(id);
		return new AnimalDto(animal);
	}

	@PutMapping("/alterar/{id}")
	@Transactional
	public ResponseEntity<AnimalDto> alterar(@PathVariable Long id, @RequestBody @Valid AtualizacaoAnimalForm form) {
		Animal animal = form.atualizar(id, animalRepository);

		return ResponseEntity.ok(new AnimalDto(animal));
	}

	@DeleteMapping("/deletar/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		animalRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/lista")
	public List<AnimalDto> lista() {
		List<Animal> animais = animalRepository.findAll();
		return AnimalDto.converterLista(animais);
	}

}
