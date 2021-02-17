package be.sven.finance.service.reader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface Reader {
    List<String> readFile(Path inputPath) throws IOException;
    void handleError(String line, Exception e) throws IOException;
    void setErrorPath(Path errorPath);
    void deleteFile(Path fileToDelete) throws IOException;
}
