/**
 * 
 */
package es.discoteca.bbdd.test.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	@Test
	public void test() {
		try {
			List<Libro> h = service.findAll();
			for (Libro libro : h) {
				LOGGER.info(libro.getNombre());
			}
			Assert.assertTrue(true);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}

}
