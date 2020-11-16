package com.deveficiente.desafiocdc.extras.autor;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.deveficiente.desafiocdc.autor.Autor;

/**
 * Carga Intrínseca: 1
 *
 */
public interface AutorRepository extends CrudRepository<Autor, Long> {

	Optional<Autor> findByEmail(String email);

}
