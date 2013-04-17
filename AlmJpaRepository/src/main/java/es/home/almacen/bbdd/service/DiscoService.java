/**
 * 
 */
package es.home.almacen.bbdd.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.home.almacen.bbdd.bean.Disco;

/**
 * @author xe29197
 * 
 */
public interface DiscoService {

	void create(String nombre, String grupo);

	List<Disco> findAll();

	Page<Disco> findAll(Pageable page);

	Disco findById(final Integer id);

	Page<Disco> findSearchDiscs(final String nombre, final String grupo, final Pageable pageable);

	void update(final Disco entity);

}
