package dio.spring.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WelcomeController {

    @GetMapping
    public String welcome(){
        return "Welcome to my aplication Spring Security Web";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('MANAGER' , 'USER')")
    public String user(){
        System.out.println("Acesso ao user");
        return "Acess USERS in aplication Spring Security Web";
    }

    @GetMapping("/adm")
    @PreAuthorize("hasRole('MANAGER')")
    public String manager(){
        System.out.println("Acesso ao manager");
        return "Acess MANAGER in aplication Spring Security Web";
    }
}
