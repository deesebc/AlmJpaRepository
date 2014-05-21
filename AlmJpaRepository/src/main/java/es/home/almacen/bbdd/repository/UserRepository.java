package es.home.almacen.bbdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.home.almacen.bbdd.bean.User;


public interface UserRepository extends  JpaRepository<User, Integer>, UserRepositoryCustom{
	
	User findByUsernameAndPassword(String username, String password);
	
	User findByUsername(String username);
}
