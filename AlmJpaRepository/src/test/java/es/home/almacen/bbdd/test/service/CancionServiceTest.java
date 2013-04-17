/**
 * 
 */
package es.home.almacen.bbdd.test.service;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.home.almacen.bbdd.bean.Cancion;
import es.home.almacen.bbdd.service.CancionService;

/**
 * @author xe29197
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/repository.xml")
public class CancionServiceTest {

	private final Logger LOGGER = Logger.getLogger(CancionServiceTest.class);

	@Autowired
	private CancionService service;

	@Test
	public void findSongsByIdDisc() {
		try {
			Integer idDisco = 1;
			final PageRequest pagina = new PageRequest(0, 10);
			Page<Cancion> h = service.findAllByIdDisc(idDisco, pagina);
			for (Cancion libro : h) {
				LOGGER.info(libro.getNombre());
			}
			Assert.assertTrue(true);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}

}
