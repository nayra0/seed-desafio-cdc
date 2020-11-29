package com.deveficiente.desafiocdc.compra;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.deveficiente.desafiocdc.compartilhado.anotacoes.CpfOuCnpjValido;
import com.deveficiente.desafiocdc.compartilhado.anotacoes.IdCadastrado;
import com.deveficiente.desafiocdc.estado.Estado;
import com.deveficiente.desafiocdc.pais.Pais;
import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 2
public class NovaCompraForm {

	@JsonProperty
	@NotBlank
	@Email
	private String email;

	@JsonProperty
	@NotBlank
	private String nome;

	@JsonProperty
	@NotBlank
	private String sobrenome;

	@JsonProperty
	@CpfOuCnpjValido()
	@NotBlank
	private String documento;

	@JsonProperty
	@CPF
	private String cpf;

	@JsonProperty
	@CNPJ
	private String cnpj;

	@JsonProperty
	@NotBlank
	private String endereco;

	@JsonProperty
	@NotBlank
	private String complemento;

	@JsonProperty
	@NotBlank
	private String cidade;

	// CI: 1
	@JsonProperty
	@IdCadastrado(entidade = Estado.class)
	private Long idEstado;

	// CI: 1
	@JsonProperty
	@NotNull
	@IdCadastrado(entidade = Pais.class)
	private Long idPais;

	@JsonProperty
	@NotBlank
	private String telefone;

	@JsonProperty
	@NotBlank
	private String cep;

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

}
