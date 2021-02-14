package be.sven.finance.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = ExpenseRepository.class)
class ExpenseRepositoryTest {
    private Expense expense1;
    private Expense expense2;
    private Expense expense3;
    private Expense expense4;
    private Expense expense5;

    @Autowired
    ExpenseRepository repository;

    @BeforeEach
    public void beforeEach() {
        expense1 = new Expense(LocalDate.of(2021, 2, 13), 124.25, ExpenseType.RELAXATION);
        expense1.setId("test1");
        expense2 = new Expense(LocalDate.of(2021, 1, 31), 25.50, ExpenseType.SHOPPING);
        expense2.setId("test2");
        expense3 = new Expense(LocalDate.of(2021, 1, 5), 66, ExpenseType.HOUSEHOLD);
        expense3.setId("test3");
        expense4 = new Expense(LocalDate.of(2021, 1, 1), 150, ExpenseType.RELAXATION);
        expense4.setId(expense1.getId());
        expense5 = new Expense(LocalDate.of(2020, 1, 1), 100, ExpenseType.DUBIOUS);
        expense5.setId("test2");
        repository.addAll(List.of(expense1, expense2, expense3));
    }

    @Test
    void add() {
        assertEquals(3, repository.findAll().size());
    }

    @Test
    void cannotAddDuplicateIds() {
        repository.addExpense(expense4);
        assertEquals(3, repository.findAll().size());
    }

    @Test
    void findById() {
        assertEquals(expense3, repository.findById("test3"));
    }

    @Test
    void remove() {
        Expense removedExpense = repository.removeExpense("test2");
        assertEquals(expense2, removedExpense);
        assertEquals(2, repository.findAll().size());
    }

    @Test
    void update() {
        repository.updateExpense("test2", expense5);
        assertEquals(expense5, repository.findById("test2"));
    }
}