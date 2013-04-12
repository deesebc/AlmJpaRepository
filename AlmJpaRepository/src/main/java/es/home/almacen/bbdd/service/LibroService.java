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

	Page<Libro> findByAutor(String autor, Pageable pageable);

	Libro findById(final Integer id);

	Page<Libro> findByNombre(String nombre, Pageable pageable);

	Page<Libro> findByNombreAndAutor(String nombre, String autor, Pageable pageable);

	Page<Libro> findByNombreAndAutorLike(String nombre, String autor, Pageable pageable);

	Page<Libro> findByNombreLike(String nombre, Pageable pageable);

	Page<Libro> findByNombreLikeAndAutorLike(String nombre, String autor, Pageable pageable);

	List<Libro> findSearchBooks(String nombre, String autor, String serie);

	Page<Libro> findSearchBooks(String nombre, String autor, String serie, Pageable pagina);

	void remove(final Libro entity);

	void update(final Libro entity);

}
