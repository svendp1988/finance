package be.sven.finance.model.mapper;

import be.sven.finance.model.Expense;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static be.sven.finance.model.ExpenseBuilder.expenseBuilder;

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

    public final DBObject toDBObject(Expense expense) {
        return new BasicDBObject("_id", expense.getId())
                .append("accountNumber", expense.getAccountNumber())
                .append("rubricName", expense.getRubricName())
                .append("name", expense.getName())
                .append("coin", expense.getCoin())
                .append("statementNumber", expense.getStatementNumber())
                .append("date", Date.from(expense.getDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()))
                .append("description", expense.getDescription())
                .append("amount", expense.getAmount())
                .append("balance", expense.getBalance())
                .append("accountCounterparty", expense.getAccountCounterparty())
                .append("nameCounterParty", expense.getNameCounterparty())
                .append("structuredCommunication", expense.getStructuredCommunication())
                .append("freeCommunication", expense.getFreeCommunication());
    }
}
