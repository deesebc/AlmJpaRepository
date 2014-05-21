package es.home.almacen.bbdd.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users", catalog = "almacen")
public class User implements java.io.Serializable, UserDetails{
	
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String username;
	private String password;
	private boolean enabled;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	
	private Set<UserRoles> authorities = new HashSet<UserRoles>(0);
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", unique = true, nullable = false)
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name = "USERNAME", length = 45)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "PASSWORD", length = 45)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "ENABLED")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	public Set<UserRoles> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<UserRoles> authorities) {
		this.authorities = authorities;
	}
	public User() {
		super();
	}
	public User(Integer userId) {
		super();
		this.userId = userId;
	}
	public User(Integer userId, String username, String password,
			boolean enabled) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	public User(Integer userId, String username, String password,
			boolean enabled, Set<UserRoles> authorities) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authorities = authorities;
	}
	
	@Override
	@Column(name = "NON_EXPIRED")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return accountNonExpired;
	}
	
	@Override
	@Column(name = "NON_LOCKED")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return accountNonLocked;
	}
	
	@Override
	@Column(name = "NON_CREDENTIAL_EXPIRED")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return credentialsNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	

}
