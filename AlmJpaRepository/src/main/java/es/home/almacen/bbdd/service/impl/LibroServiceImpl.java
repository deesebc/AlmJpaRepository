/**
 * 
 */
package es.home.almacen.bbdd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.home.almacen.bbdd.bean.Libro;
import es.home.almacen.bbdd.repository.BookRepository;
import es.home.almacen.bbdd.service.LibroService;

/**
 * @author xe29197
 * 
 */
@Service
@Transactional
public class LibroServiceImpl implements LibroService {

	@Autowired
	private BookRepository dao;

	@Override
	public void create(final Libro entity) {
		dao.save(entity);
	}

	@Override
	public List<Libro> findAll() {
		return dao.findAll();
	}

	@Override
	public Page<Libro> findAll(final Pageable page) {
		return dao.findAll(page);
	}

	@Override
	public Page<Libro> findByAutor(final String autor, final Pageable pageable) {
		return dao.findByAutor(autor, pageable);
	}

	@Override
	public Libro findById(final Integer id) {
		return dao.findOne(id);
	}

	@Override
	public Page<Libro> findByNombre(final String nombre, final Pageable pageable) {
		return dao.findByNombre(nombre, pageable);
	}

	@Override
	public Page<Libro> findByNombreAndAutor(final String nombre, final String autor,
			final Pageable pageable) {
		return dao.findByNombreAndAutor(nombre, autor, pageable);
	}

	@Override
	public Page<Libro> findByNombreAndAutorLike(final String nombre, final String autor,
			final Pageable pageable) {
		return dao.findByNombreAndAutorLike(nombre, autor, pageable);
	}

	@Override
	public Page<Libro> findByNombreLike(final String nombre, final Pageable pageable) {
		return dao.findByNombreLike(nombre, pageable);
	}

	@Override
	public Page<Libro> findByNombreLikeAndAutorLike(final String nombre, final String autor,
			final Pageable pageable) {
		return dao.findByNombreLikeAndAutorLike(nombre, autor, pageable);
	}

	@Override
	public List<Libro> findSearchBooks(final String nombre, final String autor, final String serie) {
		return dao.findSearchBooks(nombre, autor, serie);
	}

	@Override
	public Page<Libro> findSearchBooks(final String nombre, final String autor, final String serie,
			final Pageable pagina) {
		return dao.findSearchBooks(nombre, autor, serie, pagina);
	}

	@Override
	public void remove(final Libro entity) {
		dao.delete(entity);
	}

	@Override
	public void update(final Libro entity) {
		dao.save(entity);
	}

}
