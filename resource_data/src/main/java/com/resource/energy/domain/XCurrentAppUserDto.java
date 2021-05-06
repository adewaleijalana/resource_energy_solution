package com.resource.energy.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;


@Data
public class XCurrentAppUserDto extends User implements Serializable {


	private static final long serialVersionUID = -1180497821345914350L;

	private String firstName;
	private String lastName;
	private String otherName;
	private String currentUserId;

	private String login;

	private String phoneNumber;
	private String locale;
	private ZonedDateTime lastLoginTime;


	public XCurrentAppUserDto(String username, String password,
                              Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public XCurrentAppUserDto(String username, String password,
                              boolean enabled, boolean accountNonExpired,
                              boolean credentialsNonExpired, boolean accountNonLocked,
                              Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
	}

	public XCurrentAppUserDto(String username, String password,
                              boolean enabled, boolean accountNonExpired,
                              boolean credentialsNonExpired, boolean accountNonLocked,
                              Collection<? extends GrantedAuthority> authorities,
                              String firstName, String lastName,
                              String otherName, String currentUserId, String phoneNumber,
                              String locale, ZonedDateTime lastLoginTime) {
		super(username,
				password,
				enabled,
				accountNonExpired,
				credentialsNonExpired,
				accountNonLocked,
				authorities);

		this.login = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.otherName = otherName;
		this.currentUserId = currentUserId;
		this.phoneNumber = phoneNumber;this.locale = locale;
		this.lastLoginTime = lastLoginTime;

		//LOGGER.debug("this CurrentAppUserDto {}", this.toString());

	}

	public XCurrentAppUserDto(String username, String password,
                              Collection<? extends GrantedAuthority> authorities,
                              String currentUserId) {
		super(username, password, authorities);
		this.currentUserId = currentUserId;

	}
}
