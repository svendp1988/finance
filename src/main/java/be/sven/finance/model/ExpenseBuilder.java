package be.sven.finance.model;

import java.time.LocalDate;

public final class ExpenseBuilder {
    private String accountNumber;
    private String rubricName;
    private String name;
    private String coin;
    private String statementNumber;
    private LocalDate date;
    private String description;
    private double amount;
    private double balance;
    private String accountCounterparty;
    private String nameCounterparty;
    private String structuredCommunication;
    private String freeCommunication;

    private ExpenseBuilder() {
    }

    public static ExpenseBuilder expenseBuilder() {
        return new ExpenseBuilder();
    }

    public ExpenseBuilder withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public ExpenseBuilder withRubricName(String rubricName) {
        this.rubricName = rubricName;
        return this;
    }

    public ExpenseBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ExpenseBuilder withCoin(String coin) {
        this.coin = coin;
        return this;
    }

    public ExpenseBuilder withStatementNumber(String statementNumber) {
        this.statementNumber = statementNumber;
        return this;
    }

    public ExpenseBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public ExpenseBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ExpenseBuilder withAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public ExpenseBuilder withBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public ExpenseBuilder withAccountCounterparty(String accountCounterparty) {
        this.accountCounterparty = accountCounterparty;
        return this;
    }

    public ExpenseBuilder withNameCounterparty(String nameCounterparty) {
        this.nameCounterparty = nameCounterparty;
        return this;
    }

    public ExpenseBuilder withStructuredCommunication(String structuredCommunication) {
        this.structuredCommunication = structuredCommunication;
        return this;
    }

    public ExpenseBuilder withFreeCommunication(String freeCommunication) {
        this.freeCommunication = freeCommunication;
        return this;
    }

    public Expense build() {
        return new Expense(accountNumber, rubricName, name, coin, statementNumber, date, description, amount, balance, accountCounterparty, nameCounterparty, structuredCommunication, freeCommunication);
    }
}
