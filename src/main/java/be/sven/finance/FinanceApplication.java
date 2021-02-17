package be.sven.finance;

import be.sven.finance.model.reader.ExpenseReader;
import be.sven.finance.model.repository.ExpenseRepository;
import be.sven.finance.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.nio.file.Path;

@EnableWebSecurity
@SpringBootApplication
public class FinanceApplication implements CommandLineRunner {

    @Autowired
    ExpenseRepository repository;
    @Autowired
    ExpenseReader reader;
    @Autowired
    ExpenseService service;

    public static void main(String[] args) {
        SpringApplication.run(FinanceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        service.loadExpensesFromCsv(Path.of(System.getProperty("user.dir"), "src", "main", "resources", "BE00123456789101_30-09-2020_tot_14-02-2021.csv"));
    }
}
