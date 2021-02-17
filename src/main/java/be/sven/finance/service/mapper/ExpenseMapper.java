package be.sven.finance.service.mapper;

import be.sven.finance.domain.model.Expense;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static be.sven.finance.domain.model.ExpenseBuilder.expenseBuilder;

@Component
public class ExpenseMapper {
    private final DateTimeFormatter formatter;

    public ExpenseMapper() {
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public Expense toModel(String line) {
        String[] modelProperties = new String[17];
        System.arraycopy(line.split(";"), 0, modelProperties, 0, line.split(";").length);
        return expenseBuilder()
                .withAccountNumber(modelProperties[0])
                .withRubricName(modelProperties[1])
                .withName(modelProperties[2])
                .withCoin(modelProperties[3])
                .withStatementNumber(modelProperties[4])
                .withDate(LocalDate.from(formatter.parse(modelProperties[5])))
                .withDescription(modelProperties[6])
                .withAmount(Double.parseDouble(modelProperties[8].replaceAll(",", ".")))
                .withBalance(Double.parseDouble(modelProperties[9].replaceAll(",", ".")))
                .withAccountCounterparty(modelProperties[12])
                .withNameCounterparty(modelProperties[14])
                .withStructuredCommunication(modelProperties[16])
                .withFreeCommunication(null)
                .build();
    }
}
