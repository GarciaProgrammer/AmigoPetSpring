package br.com.amigopet.model;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Dica implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	private Byte imagem;
	

	public Dica() {}
	

	public Dica(String titulo, String descricao) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
	}
	
	

	public Dica(Long id, String titulo, String descricao, Byte imagem) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.imagem = imagem;
		
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Byte getImagem() {
		return imagem;
	}


	public void setImagem(Byte imagem) {
		this.imagem = imagem;
	}
	
	
	
	
	
	
}
