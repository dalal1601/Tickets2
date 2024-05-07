package com.example.tickets2.security.controllers;

import com.example.tickets2.security.entities.Role;
import com.example.tickets2.security.entities.User;
import com.example.tickets2.security.reposotories.UserRepository;
import com.example.tickets2.security.services.AccountService;
import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;

@Controller
public class SecurityController {
    private  UserRepository userRepository;
    private  PasswordEncoder passwordEncoder;

    @GetMapping("/")  //mapper les requêtes HTTP GET
    public String home(){
        return "redirect:/home";
    }
    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "/AccessDenied";
    }
    @GetMapping("/login")
    public String login(){
        return "/Login";
    }
    @GetMapping("/profile")
    public String profile(org.springframework.security.core.Authentication authentication, ModelMap modelMap) {
        if (authentication != null && authentication.isAuthenticated()) {
            String username = "Guest"; // Default username if not authenticated
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) { //Cette condition permet de s'assurer que l'utilisateur s'est authentifié correctement.
                username = ((UserDetails) principal).getUsername(); //cast (conversion de type) de l'objet principal en UserDetails
            }
            modelMap.addAttribute("username", username);
            return "Profile";
        } else {
            return "redirect:/home"; // Redirect to home page if user is not authenticated
        }
    }

    ///////////////////////
    @Autowired   // permet d'activer l'injection automatique de dépendance.
    public SecurityController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegistrationForm(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "Login";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute("user") User user, BindingResult result) {
        System.out.println("Processing registration form...");

        if (result.hasErrors()) {
            System.out.println("Binding errors: " + result.getAllErrors());
            return "Login"; // Return to the registration form if there are errors
        }

        // Check if the username is already taken
        if (userRepository.findByUsername(user.getUsername()) != null) {
            System.out.println("Username is already taken: " + user.getUsername());
            result.rejectValue("username", "error.user", "Username is already taken");
            return "Login"; // Return to the registration form if the username is taken
        }

        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("Saving user: " + user);

        // Save the user
        userRepository.save(user);
        System.out.println("User saved: " + user);

        return "redirect:/login"; // Redirect to login page after successful registration
    }


}
