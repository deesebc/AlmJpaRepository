package es.home.almacen.bbdd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "user_roles", catalog = "almacen")
public class UserRoles implements java.io.Serializable, GrantedAuthority {
	
	private static final long serialVersionUID = 1L;
	
	private Integer userRoleId;
	private String authority;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ROLE_ID", unique = true, nullable = false)
	public Integer getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	@Column(name = "AUTHORITY", length = 45)
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public UserRoles() {
		super();
	}
	public UserRoles(Integer userRoleId, String authority) {
		super();
		this.userRoleId = userRoleId;
		this.authority = authority;
	}
	
	

}
