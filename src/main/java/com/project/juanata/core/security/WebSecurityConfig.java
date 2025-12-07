package com.project.juanata.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.juanata.core.services.UsuarioService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsuarioService usuarioServe;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(usuarioServe);
		auth.setPasswordEncoder(passwordEncoder());
		
		return auth;
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/home", "/usuario/registrar", "/usuario/crear", "/usuario/admin/juanata/login",
						"/css/**", "/js/**", "/img/**", "/webjars/**").permitAll()
				.antMatchers("/usuario/admin/**").hasAuthority("ADMINISTRADOR")
				.anyRequest().permitAll()
			.and()
				.formLogin()
					.loginPage("/usuario/admin/juanata/login")
					.loginProcessingUrl("/usuario/admin/login")
					.usernameParameter("username")
					.passwordParameter("password")
					.defaultSuccessUrl("/usuario/admin/panel", true)
					.failureUrl("/usuario/admin/juanata/login?sinExito")
					.permitAll()
			.and()
				.logout()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/home")
					.permitAll();
	}
	
	

}
