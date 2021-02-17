package be.sven.finance.domain;

import be.sven.finance.domain.model.Expense;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static be.sven.finance.domain.model.ExpenseBuilder.expenseBuilder;
import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class ExpenseRepositoryIT {
    @DisplayName("given object to save"
            + " when save object using MongoDB template"
            + " then object is saved")

    @Test
    void mongoTemplateTest(@Autowired MongoTemplate template) {
        Expense test = expenseBuilder()
                .withAccountNumber("123")
                .withAmount(125)
                .withBalance(1500)
                .withCoin("EUR")
                .withName("test")
                .build();
        test.setId("test");
        template.save(test, "collection");

        assertThat(template.findById("test", Expense.class, "collection")).isEqualTo(test);
        assertThat(template.findAll(Expense.class, "collection")).extracting("amount")
                .containsOnly(125.0);
    }
}