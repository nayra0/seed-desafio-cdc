package com.deveficiente.desafiocdc.compartilhado;

import java.util.HashMap;
import java.util.function.Function;

public interface UniqueProperties{

	public <T extends UniqueProperties> HashMap<String, Function<T, String>> obterPropriedadesUnicas() ;
	
}
