package be.sven.finance.model;

import java.time.LocalDate;
import java.util.UUID;

public class Expense {
    private String id;
    private final LocalDate date;
    private final double amount;
    private final ExpenseType type;

    public Expense(LocalDate date, double amount, ExpenseType type) {
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public ExpenseType getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}
