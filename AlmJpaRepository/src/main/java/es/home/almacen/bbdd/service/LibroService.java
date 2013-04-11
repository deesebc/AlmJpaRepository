/**
 * 
 */
package es.home.almacen.bbdd.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.home.almacen.bbdd.bean.Libro;

/**
 * @author xe29197
 * 
 */
public interface LibroService {

	void create(final Libro entity);

	List<Libro> findAll();

	Page<Libro> findAll(Pageable page);

	Libro findById(final Integer id);

	void remove(final Libro entity);

	void update(final Libro entity);

}
