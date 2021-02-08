package br.com.amigopet.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigopet.controller.form.AtualizacaoUsuarioForm;
import br.com.amigopet.dto.UsuarioComSenhaDto;
import br.com.amigopet.dto.UsuarioDto;
import br.com.amigopet.model.Usuario;
import br.com.amigopet.repository.UsuarioRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@PostMapping("/cadastrar")
	public Usuario cadastrar(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@GetMapping("/visualizar/{id}")
	@Transactional
	public UsuarioDto visualizar(@PathVariable Long id) {
		Usuario usuario = usuarioRepository.getOne(id);
		return new UsuarioDto(usuario);
	}

	@PutMapping("/alterar/{id}")
	@Transactional
	public ResponseEntity<UsuarioComSenhaDto> alterar(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoUsuarioForm form) {
		Usuario usuario = form.atualizar(id, usuarioRepository);
		return ResponseEntity.ok(new UsuarioComSenhaDto(usuario));
	}

}
