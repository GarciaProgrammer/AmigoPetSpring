package br.com.amigopet.dto;

import java.util.Optional;

import br.com.amigopet.model.DadosBancarios;

public class DadosBancariosDto {
	private Long id;
	private String nomeBanco;
	private String agencia;
	private String conta;
	private String chavePix;

	public DadosBancariosDto(Long id, String nomeBanco, String agencia, String conta, String chavePix) {
		this.id = id;
		this.nomeBanco = nomeBanco;
		this.agencia = agencia;
		this.conta = conta;
		this.chavePix = chavePix;
	}

	public Long getId() {
		return id;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getConta() {
		return conta;
	}

	public String getChavePix() {
		return chavePix;
	}

	public static DadosBancariosDto converter(Optional<DadosBancarios> dadosBancarios) {
		DadosBancariosDto dadosBancariosDto = new DadosBancariosDto(dadosBancarios.get().getId(),
				dadosBancarios.get().getNomeBanco(), dadosBancarios.get().getAgencia(), dadosBancarios.get().getConta(),
				dadosBancarios.get().getChavePix());
		return dadosBancariosDto;
	}

}
