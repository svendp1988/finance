package be.sven.finance.domain.repository;

import be.sven.finance.domain.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {
    @Override
    <S extends Expense> S save(S entity);
}

