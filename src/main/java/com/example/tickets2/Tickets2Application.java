package com.example.tickets2;

import com.example.tickets2.security.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tickets2Application {

    public static void main(String[] args) {
        SpringApplication.run(Tickets2Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountService accountService){
        return args ->{
            /*accountService.createUser("admin","123","admin@gmail.com","123");
            accountService.createUser("guest","123","guest@gmail.com","123");

            accountService.creatRole("ADMIN");
            accountService.creatRole("USER");
            accountService.creatRole("GUEST");

            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("admin","USER");
            accountService.addRoleToUser("admin","GUEST");
            accountService.addRoleToUser("guest","GUEST");



            accountService.removeRoleFromUser("admin","GUEST");

             System.out.println(accountService.loadUserByUsername("admin").getEmail());

*/


        };


    }

}
