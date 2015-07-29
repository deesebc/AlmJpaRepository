/**
 * 
 */
package es.home.almacen.bbdd.test.repository;

import java.util.List;

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
import es.home.almacen.bbdd.bean.Interprete;
import es.home.almacen.bbdd.repository.DiscRepository;

/**
 * @author xe29197
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = "classpath:conf/repositoryTest.xml")
@ContextConfiguration(locations = "file:src/test/resources/conf/repositoryTest.xml")
public class DiscRepositoryTest {

	private final Logger LOGGER = Logger.getLogger(DiscRepositoryTest.class);

	@Autowired
	private DiscRepository dao;

	@Test
	public void findAll() {
		try {
			List<Disco> page = dao.findAll();
			Assert.assertTrue(page != null);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}

	@Test
	public void findInterpretes() {
		try {
			final PageRequest pageable = new PageRequest(0, 10);
			int idDisco = 1;
			Page<Interprete> page = dao.findInterpretesByIdent(idDisco,
					pageable);
			Assert.assertTrue(page != null);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}

	@Test
	public void findOne() {
		try {
			int idDisco = 1;
			Disco disco = dao.findOne(idDisco);
			Assert.assertTrue(disco != null);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}

	@Test
	public void findSingersByIdDisc() {
		try {
			final PageRequest pageable = new PageRequest(0, 10);
			int idDisco = 1;
			Page<Interprete> page = dao.findSingersByIdDisc(idDisco, pageable);
			Assert.assertTrue(page != null);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}
}
