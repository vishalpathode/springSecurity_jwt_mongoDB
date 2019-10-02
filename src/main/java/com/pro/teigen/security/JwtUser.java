package com.pro.teigen.security;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pro.teigen.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtUser implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8607562133852950260L;
	
	private final String id;
	private final String username;
	private final String password;
	private final User user;
	private final Collection<? extends GrantedAuthority> authorities;
	private final boolean enabled;
	public JwtUser(String id, String username, String password, User user,
			Collection<? extends GrantedAuthority> authorities, boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.user = user;
		this.authorities = authorities;
		this.enabled = enabled;
	}
	
	@JsonIgnore
	public String getId() {
		return id;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	public User getUser() {
		return user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@JsonIgnore // I don't want to send these values on front-end.
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	

}
