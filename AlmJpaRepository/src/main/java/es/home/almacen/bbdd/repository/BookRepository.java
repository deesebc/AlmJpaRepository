package es.home.almacen.bbdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.home.almacen.bbdd.bean.Libro;

/**
 * @author xe29197
 * 
 */
public interface BookRepository extends JpaRepository<Libro, Integer> {

}
