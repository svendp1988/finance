package be.sven.finance;

import be.sven.finance.service.reader.ExpenseReader;
import be.sven.finance.domain.repository.ExpenseRepository;
import be.sven.finance.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.nio.file.Path;

@EnableWebSecurity
@SpringBootApplication
public class FinanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceApplication.class, args);
    }

}
