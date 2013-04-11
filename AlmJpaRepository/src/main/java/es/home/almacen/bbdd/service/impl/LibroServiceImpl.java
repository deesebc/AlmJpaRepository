/**
 * 
 */
package es.home.almacen.bbdd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Libro findById(final Integer id) {
		return dao.findOne(id);
	}

	@Override
	public void remove(final Libro entity) {
		// TODO Auto-generated method stub
		dao.delete(entity);
	}

	@Override
	public void update(final Libro entity) {
		dao.save(entity);
	}

}
