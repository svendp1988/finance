package be.sven.finance;

import be.sven.finance.domain.model.Expense;
import be.sven.finance.domain.model.ExpenseBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static be.sven.finance.domain.model.ExpenseBuilder.expenseBuilder;

public class BaseTest {

    @BeforeEach
    void init_mocks() {
        MockitoAnnotations.openMocks(this);
    }

    protected static List<Expense> createMockData() {
        return Collections.singletonList(
                expenseBuilder()
                        .withAccountNumber("1234")
                        .withAmount(123.0)
                        .withBalance(1500)
                        .withDate(LocalDate.of(2021, 1, 1))
                        .build()
        );
    }
}
