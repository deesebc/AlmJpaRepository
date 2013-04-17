package es.home.almacen.bbdd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.home.almacen.bbdd.bean.Disco;

public interface DiscRepositoryCustom {

	Page<Disco> findSearchDiscs(final String nombre, final String grupo, final Pageable pagina);
}
