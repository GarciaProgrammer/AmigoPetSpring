package br.com.amigopet.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.amigopet.controller.form.AtualizacaoAnimalForm;
import br.com.amigopet.dto.AnimalDto;
import br.com.amigopet.model.Animal;
import br.com.amigopet.model.Usuario;
import br.com.amigopet.repository.AnimalRepository;
import br.com.amigopet.server.DataAnimal;

@CrossOrigin("*")
@RestController
@RequestMapping("/animal")
public class AnimalController {

	@Autowired
	AnimalRepository animalRepository;

	@Autowired
	DataAnimal dataServer;

//	@PostMapping("/cadastrar")
//	public Animal cadastrar(@RequestBody Animal animal) {
//		return animalRepository.save(animal);
//
//	}
//
//	@PostMapping("/cadastrarfoto/{idAnimal}")
//	public void cadastrar(@Valid @PathVariable("idAnimal") Long idAnimal,
//			@RequestPart(name = "imagem") MultipartFile imagem) throws Exception {
//
//		Animal animal = criaHashImagem(idAnimal, imagem);
//
//		dataServer.criaDiretorio(imagem, animal);
//
//		animalRepository.save(animal);
//
//	}

	@PostMapping("/cadastrar")
	public Animal cadastrar(@Valid @RequestParam("foto") MultipartFile foto, @RequestParam("nome") String nome,
			@RequestParam("tipo") String tipo, @RequestParam("raca") String raca, @RequestParam("idade") int idade,
			@RequestParam("sexo") String sexo, @RequestParam("descricao") String descricao,
			@RequestParam("cidade") String cidade, @RequestParam("estado") String estado,
			@RequestParam("status") String status, @RequestParam("porte") String porte,
			@RequestParam("usuario") Usuario usuario) throws Exception {

		String imagem = criaHashImagem(foto);

		Animal animal = new Animal(nome, tipo, raca, idade, sexo, descricao, imagem, usuario, cidade, estado, status, porte);
		
		// salva servidor
		dataServer.criaDiretorio(foto, animal);

		return animalRepository.save(animal);
	}

	@GetMapping("/visualizar/{id}")
	@Transactional
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

	private String criaHashImagem(MultipartFile imagem) throws Exception {
		String nome = imagem.getOriginalFilename().substring(0, imagem.getOriginalFilename().length() - 4);
		String ext = imagem.getOriginalFilename().substring(imagem.getOriginalFilename().length() - 4,
				imagem.getOriginalFilename().length());
		String imgHashSave = nome + '_' + System.currentTimeMillis() + ext;
		return imgHashSave;
	}

}
