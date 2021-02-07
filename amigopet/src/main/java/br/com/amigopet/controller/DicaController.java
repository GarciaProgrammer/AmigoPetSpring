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
import org.springframework.web.bind.annotation.RestController;

import br.com.amigopet.controller.form.AtualizacaoDicaForm;
import br.com.amigopet.dto.DicaDto;
import br.com.amigopet.model.Dica;

import br.com.amigopet.repository.DicaRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/dica")
public class DicaController {

	@Autowired
	DicaRepository dicaRepository;

	@PostMapping("/cadastrar")
	public Dica cadastrar(@RequestBody Dica dica) {
		return dicaRepository.save(dica);
	}

	@GetMapping("/visualizar/{id}")
	@Transactional
	public DicaDto visualizar(@PathVariable Long id) {
		Dica dica = dicaRepository.getOne(id);
		return new DicaDto(dica);
	}

	@PutMapping("/alterar/{id}")
	@Transactional
	public ResponseEntity<DicaDto> altera(@PathVariable Long id, @RequestBody @Valid AtualizacaoDicaForm form) {
		Dica dica = form.atualizar(id, dicaRepository);
		return ResponseEntity.ok(new DicaDto(dica));
	}

	@DeleteMapping("/deletar/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		dicaRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/lista")
	public List<DicaDto> lista() {
		List<Dica> dicas = dicaRepository.findAll();
		return DicaDto.converterLista(dicas);
	}
}
