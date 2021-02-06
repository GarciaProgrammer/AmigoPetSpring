package br.com.amigopet.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.amigopet.dto.UsuarioDto;
import br.com.amigopet.model.Usuario;
import br.com.amigopet.repository.UsuarioRepository;



@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
		
	
	@RequestMapping("/cadastra")
	@PostMapping
	public void cadastraUsuario(String nome, String email, String senha, String celular,String cidade,String estado) {
		Usuario usuario = new Usuario(nome, email, senha, celular,cidade,estado);
		usuarioRepository.save(usuario);
	}



	@RequestMapping("/visualiza")
	@GetMapping
	public UsuarioDto visualizaUsuario(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return UsuarioDto.converter(usuario);
	}
	
	
	@RequestMapping("/altera")
	@PostMapping
	public void alteraUsuario(Long id, String nome, String email, String senha, String celular,String cidade,String estado) {
		Usuario usuario = new Usuario(id , nome, email, senha, celular,cidade,estado);
		usuarioRepository.save(usuario);
	}
	
	

}
