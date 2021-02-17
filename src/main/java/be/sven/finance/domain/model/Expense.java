package be.sven.finance.domain.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Expense {
    @Id
    private String id;
    private final String accountNumber;
    private final String rubricName;
    private final String name;
    private final String coin;
    private final String statementNumber;
    private final LocalDate date;
    private final String description;
    private final double amount;
    private final double balance;
    private final String accountCounterparty;
    private final String nameCounterparty;
    private final String structuredCommunication;
    private final String freeCommunication;

    Expense(String accountNumber, String rubricName, String name, String coin, String statementNumber, LocalDate date, String description, double amount, double balance, String accountCounterparty, String nameCounterparty, String structuredCommunication, String freeCommunication) {
        this.id = UUID.randomUUID().toString();
        this.accountNumber = accountNumber;
        this.rubricName = rubricName;
        this.name = name;
        this.coin = coin;
        this.statementNumber = statementNumber;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.balance = balance;
        this.accountCounterparty = accountCounterparty;
        this.nameCounterparty = nameCounterparty;
        this.structuredCommunication = structuredCommunication;
        this.freeCommunication = freeCommunication;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getRubricName() {
        return rubricName;
    }

    public String getName() {
        return name;
    }

    public String getCoin() {
        return coin;
    }

    public String getStatementNumber() {
        return statementNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountCounterparty() {
        return accountCounterparty;
    }

    public String getNameCounterparty() {
        return nameCounterparty;
    }

    public String getStructuredCommunication() {
        return structuredCommunication;
    }

    public String getFreeCommunication() {
        return freeCommunication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Double.compare(expense.amount, amount) == 0 && Double.compare(expense.balance, balance) == 0 && Objects.equals(id, expense.id) && Objects.equals(accountNumber, expense.accountNumber) && Objects.equals(rubricName, expense.rubricName) && Objects.equals(name, expense.name) && Objects.equals(coin, expense.coin) && Objects.equals(statementNumber, expense.statementNumber) && Objects.equals(date, expense.date) && Objects.equals(description, expense.description) && Objects.equals(accountCounterparty, expense.accountCounterparty) && Objects.equals(nameCounterparty, expense.nameCounterparty) && Objects.equals(structuredCommunication, expense.structuredCommunication) && Objects.equals(freeCommunication, expense.freeCommunication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, rubricName, name, coin, statementNumber, date, description, amount, balance, accountCounterparty, nameCounterparty, structuredCommunication, freeCommunication);
    }
}
