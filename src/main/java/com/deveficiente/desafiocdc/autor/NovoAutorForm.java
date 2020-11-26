package com.deveficiente.desafiocdc.autor;

import java.util.HashMap;
import java.util.function.Function;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.deveficiente.desafiocdc.compartilhado.UniqueProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 1
public class NovoAutorForm implements UniqueProperties{

	@JsonProperty
	@NotBlank
	private String nome;

	@JsonProperty
	@NotBlank
	@Email
	private String email;
	
	@JsonProperty
	@NotBlank
	@Size(max = 400)
	private String descricao;

	// CI: 1
	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}
	
	public String getEmail() {
		return this.email;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Function<NovoAutorForm, String>> obterPropriedadesUnicas() {
		HashMap<String, Function<NovoAutorForm, String>> propriedadesUnicas = new HashMap<>();
		propriedadesUnicas.put("email", NovoAutorForm::getEmail);
		return propriedadesUnicas;
	}

}
