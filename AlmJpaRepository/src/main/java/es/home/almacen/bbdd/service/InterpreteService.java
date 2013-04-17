/**
 * 
 */
package es.home.almacen.bbdd.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.home.almacen.bbdd.bean.Interprete;

/**
 * @author xe29197
 * 
 */
public interface InterpreteService {
	Page<Interprete> findAllByIdDisc(final Integer idDisco, final Pageable pagina);
}
