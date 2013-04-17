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

import es.home.almacen.bbdd.bean.Disco;
import es.home.almacen.bbdd.service.DiscoService;

/**
 * @author xe29197
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/repository.xml")
public class DiscServiceTest {

	private final Logger LOGGER = Logger.getLogger(DiscServiceTest.class);

	@Autowired
	private DiscoService service;

	@Test
	public void findSearchDiscs() {
		try {
			final PageRequest pageable = new PageRequest(0, 10);
			String nombre = null, grupo = null;
			Page<Disco> h = service.findSearchDiscs(nombre, grupo, pageable);
			for (Disco libro : h) {
				LOGGER.info(libro.getNombre());
			}
			Assert.assertTrue(true);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}

}
