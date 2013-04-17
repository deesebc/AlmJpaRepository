package es.home.almacen.bbdd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.home.almacen.bbdd.bean.Cancion;
import es.home.almacen.bbdd.bean.Disco;
import es.home.almacen.bbdd.bean.Interprete;

/**
 * @author xe29197
 * 
 */
public interface DiscRepository extends JpaRepository<Disco, Integer>, DiscRepositoryCustom {

	@Query("select d.interpretes from Disco d where d.ident = ?1")
	Page<Interprete> findSingersByIdDisc(Integer idDisco, Pageable pagina);

	@Query("select d.canciones from Disco d where d.ident = ?1")
	Page<Cancion> findSongsByIdDisc(Integer idDisco, Pageable pagina);
}
