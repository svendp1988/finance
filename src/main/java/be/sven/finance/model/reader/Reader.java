package be.sven.finance.model.reader;

import java.nio.file.Path;
import java.util.List;

public interface Reader {
    List<String> readFile();
    void handleError(String line, Exception e);
    void setInputhPath(Path inputhPath);
    void setErrorPath(Path errorPath);
}
