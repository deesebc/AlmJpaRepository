package es.home.almacen.bbdd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.home.almacen.bbdd.bean.User;
import es.home.almacen.bbdd.repository.UserRepository;
import es.home.almacen.bbdd.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository dao;
	
	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return dao.findByUsernameAndPassword(username, password);
	}

	@Override
	public User findByUsername(String username) {
		return dao.findByUsername(username);
	}

}
