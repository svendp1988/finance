package be.sven.finance.api.exceptions;

public class ExpenseNotFoundException extends RuntimeException {
    public ExpenseNotFoundException(String id) {
        super("Could not find expense with id: " + id);
    }
}
