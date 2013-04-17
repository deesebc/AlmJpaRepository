/**
 * 
 */
package es.home.almacen.bbdd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.home.almacen.bbdd.bean.Cancion;
import es.home.almacen.bbdd.repository.DiscRepository;
import es.home.almacen.bbdd.service.CancionService;

/**
 * @author xe29197
 * 
 */
@Service
@Transactional
public class CancionServiceImpl implements CancionService {

	@Autowired
	private DiscRepository dao;

	@Override
	public Page<Cancion> findAllByIdDisc(final Integer idDisco, final Pageable pagina) {
		return dao.findSongsByIdDisc(idDisco, pagina);
	}
}
