/**
 * 
 */
package es.home.almacen.bbdd.test.repository;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.home.almacen.bbdd.bean.User;
import es.home.almacen.bbdd.bean.UserRoles;
import es.home.almacen.bbdd.repository.UserRepository;

/**
 * @author xe29197
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/repositoryTest.xml")
public class UserRepositoryTest {

	private final Logger LOGGER = Logger.getLogger(UserRepositoryTest.class);

	@Autowired
	private UserRepository dao;

	@Test
	public void count() {
		try {
			long count = dao.count();
			Assert.assertTrue(count > 0);
			LOGGER.debug("Contador: " + count);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}

	@Test
	@Ignore
	public void add() {
		try {
			User user = new User();
			user.setEnabled(true);
			user.setPassword("123456");
			user.setUsername("user1");
			Set<UserRoles> userRoles = new HashSet<UserRoles>();
			// UserRoles userRoles1 = new UserRoles();
			// userRoles1.setAuthority("ADMIN");
			// userRoles.add(userRoles1);
			// user.setUserRoles(userRoles);
			UserRoles userRoles2 = new UserRoles();
			userRoles2.setAuthority("USER");
			userRoles.add(userRoles2);
			user.setAuthorities(userRoles);
			user = dao.save(user);
			Assert.assertTrue(user.getUserId() != null);
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}

}
