/**
 * 
 */
package es.discoteca.bbdd.test.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
