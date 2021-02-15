package be.sven.finance.model.reader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class ExpenseReaderTest {
    @Autowired
    ExpenseReader reader;

    Path testInput = Path.of(System.getProperty("user.dir"), "src", "test", "resources", "test_expense_input.csv");
    Path errorPath = Path.of(System.getProperty("user.dir"), "src", "test", "resources", "test_error.log");


    @BeforeEach
    void setUp() throws IOException {
        Files.deleteIfExists(errorPath);
        reader.setInputhPath(testInput);
        reader.setErrorPath(errorPath);
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(errorPath);
    }

    @Test
    void readFile() {
        List<String> input = reader.readFile();
        assertEquals(13, input.size());
    }

    @Test
    void handleError() {
        Path wrongPath = Path.of("wrong_path");
        reader.setInputhPath(wrongPath);
        reader.readFile();
        assertTrue(Files.exists(errorPath));
    }
}