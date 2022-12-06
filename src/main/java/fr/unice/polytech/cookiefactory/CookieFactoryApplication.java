package fr.unice.polytech.cookiefactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class CookieFactoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CookieFactoryApplication.class, args);
    }
}
