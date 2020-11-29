package com.deveficiente.desafiocdc.pais;

import java.util.HashMap;
import java.util.function.Function;

import javax.validation.constraints.NotBlank;

import com.deveficiente.desafiocdc.compartilhado.UniqueProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 1
public class NovoPaisForm implements UniqueProperties{

	@JsonProperty
	@NotBlank
	private String nome;

	// CI: 1
	public Pais toModel() {
		return new Pais(this.nome);
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Function<NovoPaisForm, String>> obterPropriedadesUnicas() {
		HashMap<String, Function<NovoPaisForm, String>> propriedadesUnicas = new HashMap<>();
		propriedadesUnicas.put("nome", NovoPaisForm::getNome);
		return propriedadesUnicas;
	}

	public String getNome() {
		return nome;
	}

}
