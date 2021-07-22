package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}



	@Autowired
	private DataSource dataSource;


	private static final String USER_SQL = "SELECT" +" id,"
		                                               +" pass,"
				                                       +" true"
		                                               +" FROM"
				                                       +" users2"
		                                               +" WHERE"
				                                       +" id=?";



	private static final String ROLE_SQL="SELECT"
				                             +" id,"
				                             +" role"
				                             +" FROM"
				                             +" users2"
				                             +" WHERE"
				                             +" id=?";



	@Override
	public void configure(WebSecurity web)throws Exception {

		web.ignoring().antMatchers("/webjars/**","/css/**");
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception{


		http
		 .authorizeRequests()
		  .antMatchers("/webjars/**").permitAll()//webjarsへアクセス許可
		  .antMatchers("/css/**").permitAll()//cssへアクセス許可
		  .antMatchers("/login").permitAll()//ユーザー登録画面は直リンクＯＫ
		  .antMatchers("/registration").permitAll()//ユーザー登録画面は直リンクＯＫ
		  .anyRequest().authenticated();//それ以外は直リンク禁止


		http
		 .formLogin()
		  .loginProcessingUrl("/login")//ログイン処理のパス
		  .loginPage("/login")//ログインページの指定
		  .failureUrl("/login")//ログイン失敗時の遷移先
		  .usernameParameter("userId")//ログインページのユーザーID
		  .passwordParameter("password")//ログインページのパスワード
		  .defaultSuccessUrl("/workList",true);//ログイン成功後の遷移先






		http.csrf().disable();
	}



	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception{

		auth.jdbcAuthentication()
		    .dataSource(dataSource)
		    .usersByUsernameQuery(USER_SQL)
		    .authoritiesByUsernameQuery(ROLE_SQL)
	        .passwordEncoder(passwordEncoder());

	}


}
