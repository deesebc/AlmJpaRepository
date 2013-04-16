package es.home.almacen.bbdd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.home.almacen.bbdd.bean.Libro;

public interface BookRepositoryCustom {

	Page<Libro> findSearchBooks(final String nombre, final String autor, final String serie,
			final Pageable pagina);
}
