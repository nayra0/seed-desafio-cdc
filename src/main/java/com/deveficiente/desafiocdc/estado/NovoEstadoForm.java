package com.deveficiente.desafiocdc.estado;

import java.util.HashMap;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.deveficiente.desafiocdc.compartilhado.UniqueProperties;
import com.deveficiente.desafiocdc.compartilhado.anotacoes.IdCadastrado;
import com.deveficiente.desafiocdc.pais.Pais;
import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 3
// CI : 1
public class NovoEstadoForm implements UniqueProperties {
	
	@JsonProperty
	@NotBlank
	private String nome;
	
	@JsonProperty
	@NotNull
	@IdCadastrado(entidade = Pais.class)
	private Long idPais;
	
	// CI: 2
	public Estado toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, this.idPais);
		return new Estado(this.nome, pais);
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Function<NovoEstadoForm, String>> obterPropriedadesUnicas() {
		HashMap<String, Function<NovoEstadoForm, String>> propriedadesUnicas = new HashMap<>();
		propriedadesUnicas.put("nome", NovoEstadoForm::getNome);
		return propriedadesUnicas;
	}

	public String getNome() {
		return nome;
	}

}
