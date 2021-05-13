
package com.company.blog.config;

import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .authorizeRequests()
                    .antMatchers("/", "/Home", "/Accommodation", "/Infrastructure", "/Price", "/Сommunications", "/AboutUs", "/Rules", "/Comment", "/payment")
                .permitAll()
                .antMatchers("/StaffAccount/**").hasRole("STAFF")
                .antMatchers("/MyAccount/**").hasRole("CLIENT")
                .antMatchers("/AdminHome/**", "/StaffFilter", "/AllActualInformation/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()

                .formLogin()
                .loginPage("/Authorization")
                .permitAll()
                //Перенарпавление на страницу после успешного входа
                //.defaultSuccessUrl("/StaffAccount")
                // .antMatchers("/StaffAccount").hasRole("STAFF")

                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
    }


    @Bean
    public UserDetailsService users() {
        UserDetails staff =  User.withDefaultPasswordEncoder()
                .username("1")
                .password("1")
                .roles("STAFF")
                .build();

        UserDetails client =  User.withDefaultPasswordEncoder()
                .username("2")
                .password("2")
                .roles("CLIENT")
                .build();

        UserDetails admin =  User.withDefaultPasswordEncoder()
                .username("3")
                .password("3")
                .roles("ADMIN")
                .build();




        return new InMemoryUserDetailsManager(staff, client, admin);
    }




/*
    @Bean
    @Override
    
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("1")
                        .password("1")
                        .roles("STAFF")
                        .build();

        UserDetails client =
                User.withDefaultPasswordEncoder()
                        .username("2")
                        .password("2")
                        .roles("CLIENT")
                        .build();

        UserDetails admin =
                User.withDefaultPasswordEncoder()
                        .username("3")
                        .password("3")
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(admin);
    }

 */






/*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select position, password, active from usr where position=?")
                .authoritiesByUsernameQuery("select p.position, pr.roles from usr p inner join user_role pr on p.id = pr.position_id where p.position=?");
    }
*/



    /* Разрешаем Spring Security допускать следующие директории */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/img/**","/scripts/**");

         }
}











/*
package com.company.blog.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                    .disable()
                .authorizeRequests()
                    //Доступ только для не зарегистрированных пользователей
                    .antMatchers("/registration").not().fullyAuthenticated()
                    //Доступ только для пользователей с ролью Администратор
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/news").hasRole("USER")
                    //Доступ разрешен всем пользователей
                    .antMatchers("/", "/aboutUs", "/resources/**").permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and()
                    //Настройка для входа в систему
                    .formLogin()
                    .loginPage("/login")
                    //Перенарпавление на главную страницу после успешного входа
                    .defaultSuccessUrl("/")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll()
                    .logoutSuccessUrl("/");
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }
}

 */



