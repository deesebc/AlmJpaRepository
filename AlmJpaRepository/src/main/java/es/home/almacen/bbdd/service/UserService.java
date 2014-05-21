package es.home.almacen.bbdd.service;

import es.home.almacen.bbdd.bean.User;

public interface UserService {
	
	User findByUsernameAndPassword(String username, String password);
	
	User findByUsername(String username);

}
