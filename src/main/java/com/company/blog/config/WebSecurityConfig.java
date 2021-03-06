
package com.company.blog.config;

import ch.qos.logback.core.net.server.Client;
import com.company.blog.service.UserService;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;
    /*
    @Autowired
    private DataSource dataSource;

     */
/* */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    public WebSecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }



//        @Bean
//        public SpringSecurityDialect springSecurityDialect(){
//            return new SpringSecurityDialect();
//        }






    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http


                //.csrf()
               // .disable()
//                .requiresChannel()
//                .anyRequest()
//                .requiresSecure()
//                .and()
//                .csrf()
//                .disable()

                .authorizeRequests()

                .antMatchers("/css/**","/img/**","/scripts/**").permitAll()
                .antMatchers( "/resources/**", "/", "/PhotoGallery",   "/Payment", "/Registration", "/Accommodation", "/Infrastructure", "/Price", "/??ommunications", "/AboutUs", "/Rules",  "/payment")
                .permitAll()
                .antMatchers("/StaffAccount", "/StaffEvent","/StaffTimeTable","StaffActualInformation").hasRole("STAFF")
                .antMatchers("/MyAccount","/Event", "/Request","/Comment","/TimeTable","ActualInformation").hasRole("CLIENT")
                .antMatchers("/AdminHome", "/StaffFilter", "/AllRequestAdminFilter", "/AdminRequest/**", "/AdminEvent/**",  "/RoomsAdmin/**", "/AdminActualInformation/**", "/AllComment/**", "/Staffs/**","/AllClients/**","/Accounts").hasRole("ADMIN")
                .anyRequest()
                .authenticated()

                .and()

                .formLogin()
                .loginPage("/Authorization")
                .successHandler(authenticationSuccessHandler)
                .permitAll()
               // ?????????????????????????????? ???? ???????????????? ?????????? ?????????????????? ??????????
              //  .defaultSuccessUrl("/AdminHome")
                // .antMatchers("/StaffAccount").hasRole("STAFF")

                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
    }

    /*   @Autowired
       public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
           auth
                   .inMemoryAuthentication()
                   .withUser("user").password("pass").roles("USER")
                   .and()
                   .withUser("admin").password("pass").roles("ADMIN");
       }
    */
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }



/*
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

 */




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



    /* ?????????????????? Spring Security ?????????????????? ?????????????????? ???????????????????? */
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
                    //???????????? ???????????? ?????? ???? ???????????????????????????????????? ??????????????????????????
                    .antMatchers("/registration").not().fullyAuthenticated()
                    //???????????? ???????????? ?????? ?????????????????????????? ?? ?????????? ??????????????????????????
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/news").hasRole("USER")
                    //???????????? ???????????????? ???????? ??????????????????????????
                    .antMatchers("/", "/aboutUs", "/resources/**").permitAll()
                //?????? ?????????????????? ???????????????? ?????????????? ????????????????????????????
                .anyRequest().authenticated()
                .and()
                    //?????????????????? ?????? ?????????? ?? ??????????????
                    .formLogin()
                    .loginPage("/login")
                    //?????????????????????????????? ???? ?????????????? ???????????????? ?????????? ?????????????????? ??????????
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



