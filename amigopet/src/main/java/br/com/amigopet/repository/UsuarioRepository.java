package br.com.amigopet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.amigopet.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Boolean existsByEmail(String email);

	Boolean existsBySenha(String senha);

	Usuario findByEmail(String email);

}
