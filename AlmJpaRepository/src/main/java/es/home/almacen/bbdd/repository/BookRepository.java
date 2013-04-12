package es.home.almacen.bbdd.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.home.almacen.bbdd.bean.Libro;

/**
 * @author xe29197
 * 
 */
public interface BookRepository extends JpaRepository<Libro, Integer> {

	Page<Libro> findByAutor(String autor, Pageable pageable);

	Page<Libro> findByNombre(String nombre, Pageable pageable);

	Page<Libro> findByNombreAndAutor(String nombre, String autor, Pageable pageable);

	Page<Libro> findByNombreAndAutorLike(String nombre, String autor, Pageable pageable);

	Page<Libro> findByNombreLike(String nombre, Pageable pageable);

	Page<Libro> findByNombreLikeAndAutorLike(String nombre, String autor, Pageable pageable);

	@Query("select l from Libro l where l.nombre like :nombre or l.autor like :autor or l.serie like :serie")
	List<Libro> findSearchBooks(@Param("nombre") String nombre, @Param("autor") String autor,
			@Param("serie") String serie);

	@Query("select l from Libro l where l.nombre like ?1 or l.autor like ?2 or l.serie like ?3")
	Page<Libro> findSearchBooks(String nombre, String autor, String serie, Pageable pagina);
}
