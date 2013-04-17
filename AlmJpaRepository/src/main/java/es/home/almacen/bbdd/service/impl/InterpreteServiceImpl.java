/**
 * 
 */
package es.home.almacen.bbdd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.home.almacen.bbdd.bean.Interprete;
import es.home.almacen.bbdd.repository.DiscRepository;
import es.home.almacen.bbdd.service.InterpreteService;

/**
 * @author xe29197
 * 
 */
@Service
@Transactional
public class InterpreteServiceImpl implements InterpreteService {
	@Autowired
	private DiscRepository dao;

	@Override
	public Page<Interprete> findAllByIdDisc(final Integer idDisco, final Pageable pagina) {
		return dao.findSingersByIdDisc(idDisco, pagina);
	}
}
