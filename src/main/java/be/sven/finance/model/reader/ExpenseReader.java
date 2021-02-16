package be.sven.finance.model.reader;

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
    private Path errorPath = Path.of(System.getProperty("user.home"), "myfinance", "logs", "error-" + LocalDate.now().toString() + ".log");

    @Override
    public List<String> readFile(Path inputhPath) throws IOException {
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
    public void handleError(String line, Exception e) throws IOException {
        if (Files.notExists(errorPath.getParent())) {
            Files.createDirectory(errorPath.getParent());
        }
        try (BufferedWriter writer = Files.newBufferedWriter(errorPath, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(String.format("An error occurred in line: %s. Error: %s%n", line, e));
        }
    }

    @Override
    public void setErrorPath(Path errorPath) {
        this.errorPath = errorPath;
    }

    @Override
    public void deleteFile(Path fileToDelete) throws IOException {
        Files.deleteIfExists(fileToDelete);
    }
}
