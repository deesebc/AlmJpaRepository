/**
 * 
 */
package es.home.almacen.bbdd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.home.almacen.bbdd.bean.Disco;
import es.home.almacen.bbdd.repository.DiscRepository;
import es.home.almacen.bbdd.service.DiscoService;

/**
 * @author xe29197
 * 
 */
@Service
@Transactional
public class DiscoServiceImpl implements DiscoService {

	@Autowired
	private DiscRepository dao;

	@Override
	public void create(final String nombre, final String grupo) {
		Disco bean = new Disco();
		bean.setGrupo(grupo);
		bean.setNombre(nombre);
		dao.save(bean);
	}

	@Override
	public List<Disco> findAll() {
		return dao.findAll();
	}

	@Override
	public Disco findById(final Integer id) {
		return dao.findOne(id);
	}

	@Override
	public void update(final Disco entity) {
		dao.save(entity);
	}

}
