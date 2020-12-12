package com.fennec.freelanceproject;

import com.fennec.freelanceproject.model.AppRole;
import com.fennec.freelanceproject.model.AppUser;
import com.fennec.freelanceproject.service.AccountService;
import com.fennec.freelanceproject.service.AccountServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FreelanceprojectApplication implements CommandLineRunner {

    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(FreelanceprojectApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        //accountService.saveRole(new AppRole(null, "ADMIN"));
        //accountService.saveRole(new AppRole(null, "CLIENT"));
        //accountService.saveRole(new AppRole(null, "FREELANCER"));
        //accountService.saveUser(new AppUser(null, "sysadmin@sysadmin", "xxb=$c5Mj", null));
        //accountService.addRoleToUser("sysadmin@sysadmin", "ADMIN");

        //System.out.println("user created : " + accountService.findUserByUsername("houcine").toString());
    }
}
