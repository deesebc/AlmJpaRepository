/**
 * 
 */
package es.home.almacen.bbdd.service;

import java.util.List;

import es.home.almacen.bbdd.bean.Libro;

/**
 * @author xe29197
 * 
 */
public interface LibroService {

	void create(final Libro entity);

	List<Libro> findAll();

	Libro findById(final Integer id);

	void remove(final Libro entity);

	void update(final Libro entity);

}
