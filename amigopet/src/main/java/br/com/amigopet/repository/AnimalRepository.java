package br.com.amigopet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.amigopet.model.Animal;
import br.com.amigopet.model.Usuario;

public interface AnimalRepository extends JpaRepository<Animal, Long> {


	List<Animal> findAllByUsuario(Usuario usuario);

	List<Animal> findAllByStatus(String status);

	List<Animal> findAllByStatusAndUsuario(String status, Usuario usuario);

//	List<Animal> findAllByEstadoAndCidadeAndPorteAndEspecieAndSexoAndIdade(int estado, int cidade, String porte,
//			String especie, String sexo, String idade);

}
