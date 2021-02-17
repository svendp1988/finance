package be.sven.finance.service.mapper;

import be.sven.finance.BaseTest;
import be.sven.finance.domain.model.Expense;
import be.sven.finance.domain.model.ExpenseBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static be.sven.finance.domain.model.ExpenseBuilder.expenseBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExpenseMapperTest extends BaseTest {
    String line = "BE00 1234 5678 9101;;JANSSEN JAN;EUR;2020001;30/09/2020;\"OVERSCHRIJVING VAN BE11 0987 6543 2100 BANKIER OPDRACHTGEVER: KREDBEBB JANSSEN JAN GRENADIERSTRAAT     1    A000 9000    GENT\";01/10/2020;250,00;250,00;250,00;;BE11 0987 6543 2100;KREDBEBB;JANSSEN JAN;GRENADIERSTRAAT     1    A000 3900    GENT;;;\n";

    @Autowired
    ExpenseMapper mapper;

    @Test
    void toModel() {
        Expense actual = mapper.toModel(line);
        Expense expected = expenseBuilder()
                .withRubricName("")
                .withAccountNumber("BE00 1234 5678 9101")
                .withName("JANSSEN JAN")
                .withCoin("EUR")
                .withStatementNumber("2020001")
                .withStructuredCommunication("")
                .withDate(LocalDate.of(2020, 9, 30))
                .withDescription("\"OVERSCHRIJVING VAN BE11 0987 6543 2100 BANKIER OPDRACHTGEVER: KREDBEBB JANSSEN JAN GRENADIERSTRAAT     1    A000 9000    GENT\"")
                .withAmount(250.0)
                .withBalance(250.0)
                .withAccountCounterparty("BE11 0987 6543 2100")
                .withNameCounterparty("JANSSEN JAN")
                .build();
        assertThat(actual)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(expected);
    }
}