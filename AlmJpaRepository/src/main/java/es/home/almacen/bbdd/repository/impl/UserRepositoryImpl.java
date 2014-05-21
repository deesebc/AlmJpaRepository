/**
 * 
 */
package es.home.almacen.bbdd.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import es.home.almacen.bbdd.bean.User;
import es.home.almacen.bbdd.repository.UserRepositoryCustom;

/**
 * @author xe29197
 * 
 */
@Repository
public class UserRepositoryImpl extends AbstractRepositoryImpl<User> implements UserRepositoryCustom {

	@PersistenceContext
	private EntityManager em;



}
