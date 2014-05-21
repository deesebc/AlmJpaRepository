/**
 * 
 */
package es.home.almacen.bbdd.test.service;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.home.almacen.bbdd.bean.User;
import es.home.almacen.bbdd.service.UserService;

/**
 * @author xe29197
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/repository.xml")
public class UserServiceTest {

	private final Logger LOGGER = Logger.getLogger(UserServiceTest.class);

	@Autowired
	private UserService service;

	@Test
	public void findByUsername() {
		try {
			User user = service.findByUsername("admin");
			
			LOGGER.info("Username: "+user.getUsername());
			LOGGER.info("Password: "+user.getPassword());
			LOGGER.info("Id: "+user.getUserId());
			Assert.assertTrue(true);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}


}
