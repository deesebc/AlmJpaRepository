/**
 * 
 */
package es.home.almacen.bbdd.test.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.home.almacen.bbdd.bean.Libro;
import es.home.almacen.bbdd.service.LibroService;

/**
 * @author xe29197
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/repository.xml")
public class BookServiceTest {

	private final Logger LOGGER = Logger.getLogger(BookServiceTest.class);

	@Autowired
	private LibroService service;

	@Test
	public void findAll() {
		try {
			final PageRequest page1 = new PageRequest(0, 10);
			Page<Libro> h = service.findAll(page1);
			LOGGER.info("Libros ");
			for (Libro libro : h.getContent()) {
				LOGGER.info(libro.getNombre());
			}
			LOGGER.info("Total " + h.getTotalElements());
			Assert.assertTrue(true);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}

	@Test
	public void findByAutor() {
		try {
			String autor = "a3";
			Pageable pageable = null;
			Page<Libro> h = service.findByAutor(autor, pageable);
			for (Libro libro : h) {
				LOGGER.info(libro.getNombre());
			}
			Assert.assertTrue(true);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}

	@Test
	public void findByNombreAndAutor() {
		try {
			String autor = "a3";
			String nombre = "n3";
			Pageable pageable = null;
			Page<Libro> h = service.findByNombreAndAutor(nombre, autor, pageable);
			for (Libro libro : h) {
				LOGGER.info(libro.getNombre());
			}
			Assert.assertTrue(true);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}

	@Test
	public void findByNombreAndAutorLike() {
		try {
			String autor = "a3";
			String nombre = "n3";
			Pageable pageable = null;
			Page<Libro> h = service.findByNombreAndAutorLike(nombre, autor, pageable);
			for (Libro libro : h) {
				LOGGER.info(libro.getNombre());
			}
			Assert.assertTrue(true);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}

	@Test
	public void findByNombreLike() {
		try {
			String nombre = "n";
			Pageable pageable = null;
			Page<Libro> h = service.findByNombreLike(nombre, pageable);
			for (Libro libro : h) {
				LOGGER.info(libro.getNombre());
			}
			Assert.assertTrue(true);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}

	@Test
	public void findByNombreLikeAndAutorLike() {
		try {
			String autor = "a3";
			String nombre = "n3";
			Pageable pageable = null;
			Page<Libro> h = service.findByNombreLikeAndAutorLike(nombre, autor, pageable);
			for (Libro libro : h) {
				LOGGER.info(libro.getNombre());
			}
			Assert.assertTrue(true);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}

	@Test
	public void findSearchBooks() {
		try {
			String nombre = "n";
			String autor = "n";
			String serie = "n";
			Pageable pageable = null;
			List<Libro> h = service.findSearchBooks(nombre, autor, serie);
			for (Libro libro : h) {
				LOGGER.info(libro.getNombre());
			}
			Assert.assertTrue(true);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}

	@Test
	public void findSearchBooksPage() {
		try {
			int page = 0;
			int rows = 5;
			final Sort sort = new Sort("nombre");
			final PageRequest pageable = new PageRequest(page, rows, sort);

			String nombre = "n3";
			String autor = "a3";
			String serie = "s3";
			Page<Libro> h = service.findSearchBooks(nombre, autor, serie, pageable);
			for (Libro libro : h) {
				LOGGER.info(libro.getNombre());
			}
			Assert.assertTrue(true);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}

	@Test
	@Ignore
	public void save() {
		try {
			Libro entity = new Libro();
			entity.setNombre("Nombre prueba test 3");
			entity.setAutor("Autor prueba test 3");
			service.create(entity);
			LOGGER.info("Libro creado");
			Assert.assertTrue(true);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}

}
