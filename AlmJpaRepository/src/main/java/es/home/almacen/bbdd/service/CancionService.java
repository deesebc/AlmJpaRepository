/**
 * 
 */
package es.home.almacen.bbdd.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.home.almacen.bbdd.bean.Cancion;

/**
 * @author xe29197
 * 
 */
public interface CancionService {
	Page<Cancion> findAllByIdDisc(final Integer idDisco, final Pageable pagina);
}
