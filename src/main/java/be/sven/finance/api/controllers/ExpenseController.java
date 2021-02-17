package be.sven.finance.api.controllers;

import be.sven.finance.api.exceptions.ExpenseNotFoundException;
import be.sven.finance.domain.model.Expense;
import be.sven.finance.service.ExpenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@RestController
public class ExpenseController {
    private final ExpenseService service;
    private static final Logger LOGGER = LoggerFactory.getLogger(ExpenseController.class);

    @Autowired
    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping(value = "/expenses", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public List<Expense> findAll() {
        LOGGER.info("Getting all expenses");
        List<Expense> allExpenses = service.findAll();
        return allExpenses;
    }

    @PostMapping("/expenses/start")
    public void start() throws IOException {
        LOGGER.info("Reading all expenses from csv file");
        service.loadExpensesFromCsv(Path.of(System.getProperty("user.dir"), "src", "main", "resources", "BE00123456789101_30-09-2020_tot_14-02-2021.csv"));
    }

    @GetMapping("/expenses/{id}")
    public Expense findById(@PathVariable String id) {
        return service.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException(id));
    }
}
