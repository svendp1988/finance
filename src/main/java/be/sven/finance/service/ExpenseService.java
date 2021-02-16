package be.sven.finance.service;

import be.sven.finance.model.Expense;
import be.sven.finance.model.mapper.ExpenseMapper;
import be.sven.finance.model.reader.ExpenseReader;
import be.sven.finance.model.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private final ExpenseRepository repository;
    private final ExpenseReader reader;
    private final ExpenseMapper mapper;

    @Autowired
    public ExpenseService(ExpenseRepository repository, ExpenseReader reader, ExpenseMapper mapper) {
        this.repository = repository;
        this.reader = reader;
        this.mapper = mapper;
    }

    public void loadExpensesFromCsv(Path inputhPath) throws IOException {
        reader.readFile(inputhPath)
                .stream()
                .map(mapper::toModel)
                .forEach(repository::save);
//        reader.deleteFile(inputhPath);
    }

    public List<Expense> findAll() {
        return repository.findAll();
    }

    public Optional<Expense> findById(String id) {
        return repository.findById(id);
    }
}
