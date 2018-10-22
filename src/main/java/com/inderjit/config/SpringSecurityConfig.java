package com.inderjit.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@PropertySource("classpath:database.properties")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${jdbc.driverClassName}")
    private String driverName;

    @Value("${jdbc.databaseServerName}")
    private String serverName;

    @Value("${jdbc.databasePort}")
    private String serverPort;

    @Value("${jdbc.databaseName}")
    private String databaseName;

    @Value("${jdbc.databaseUsername}")
    private String userName;

    @Value("${jdbc.databasePassword}")
    private String userPassword;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/about", "/login", "/register", "/error", "/pricing", "/feature**", "/contact", "/forgotPassword", "/defaultSetting", "/restartTomcatNow", "/restartTomcatLater", "/savehrconfig","/manager","/testGames").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER")
//                .and()
//                .withUser("admin").password("password").roles("ADMIN");
//        String findUserquery = "select userLoginName,userLoginPwd,1 from users where userLoginName=?";
//        String findUserRolequery = "select userLoginName,Role from users where userLoginName=?";
//        auth.jdbcAuthentication().dataSource(dataSource())
//                .usersByUsernameQuery(findUserquery)
//                .authoritiesByUsernameQuery(findUserRolequery)
//                .passwordEncoder(passwordEncoder);
        auth.userDetailsService(loginUserDetailsService).passwordEncoder(passwordEncoder);
    }

    @Autowired
    @Qualifier("loginUserDetailsService")
    LoginUserDetailService loginUserDetailsService;

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(driverName);
        String dataBaseUrl = "jdbc:sqlserver://" + serverName + ":" + serverPort + ";databaseName=" + databaseName;
        driverManagerDataSource.setUrl(dataBaseUrl);
        driverManagerDataSource.setUsername(userName);
        driverManagerDataSource.setPassword(userPassword);
        return driverManagerDataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
