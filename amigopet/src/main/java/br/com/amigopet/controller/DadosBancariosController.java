package br.com.amigopet.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigopet.dto.DadosBancariosDto;
import br.com.amigopet.model.DadosBancarios;
import br.com.amigopet.model.Usuario;
import br.com.amigopet.repository.DadosBancariosRepository;

@CrossOrigin
@RestController
@RequestMapping("/dadosbancarios")
public class DadosBancariosController {

	@Autowired
	DadosBancariosRepository dadosBancariosRepository;

	@RequestMapping("/cadastra")
	@PostMapping
	public void cadastraDadosBancarios(String nomeBanco, String agencia, String conta, String chavePix,
			Usuario usuario) {
		DadosBancarios dadosBancarios = new DadosBancarios(nomeBanco, agencia, conta, chavePix, usuario);
		dadosBancariosRepository.save(dadosBancarios);
	}

	@RequestMapping("/visualiza")
	@PostMapping
	public DadosBancariosDto visualizaDadosBancarios(Long id) {
		Optional<DadosBancarios> dadosBancarios = dadosBancariosRepository.findById(id);
		return DadosBancariosDto.converter(dadosBancarios);
	}

	@RequestMapping("/altera")
	@PostMapping
	public void alteraDadosBancarios(Long id, String nomeBanco, String agencia, String conta, String chavePix,
			Usuario usuario) {
		DadosBancarios dadosBancarios = new DadosBancarios(id, nomeBanco, agencia, conta, chavePix, usuario);
		dadosBancariosRepository.save(dadosBancarios);
	}

	@RequestMapping("/deleta")
	@PostMapping
	public void deletaDadosBancarios(Long id) {
		dadosBancariosRepository.deleteById(id);

	}

	@GetMapping("/lista")
	public void listaDadosBancarios() {

	}

}
