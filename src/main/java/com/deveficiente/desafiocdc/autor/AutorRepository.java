package com.deveficiente.desafiocdc.autor;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

/**
 * Carga Intrínseca: 1
 *
 */
public interface AutorRepository extends CrudRepository<Autor, Long> {

	Optional<Autor> findByEmail(String email);

}
