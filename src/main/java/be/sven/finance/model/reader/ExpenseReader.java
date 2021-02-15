package be.sven.finance.model.reader;

import be.sven.finance.model.Expense;
import be.sven.finance.model.mapper.ExpenseMapper;
import be.sven.finance.model.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.newBufferedReader;

@Component
public class ExpenseReader implements Reader {
    private Path inputhPath;
    private Path errorPath = Path.of(System.getProperty("user.home"), "myfinance", "logs", "error-" + LocalDate.now().toString() + ".log");

    @Override
    public List<String> readFile() {
        String line = null;
        List<String> input = new ArrayList<>();
        try (BufferedReader reader = newBufferedReader(inputhPath)) {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            handleError(line, e);
        }
        return input;
    }

    @Override
    public void handleError(String line, Exception e) {
        if (Files.notExists(errorPath.getParent())) {
            try {
                Files.createDirectory(errorPath.getParent());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        try (BufferedWriter writer = Files.newBufferedWriter(errorPath, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(String.format("An error occurred in line: %s. Error: %s\n", line, e));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public void setInputhPath(Path inputhPath) {
        this.inputhPath = inputhPath;
    }

    @Override
    public void setErrorPath(Path errorPath) {
        this.errorPath = errorPath;
    }
}
