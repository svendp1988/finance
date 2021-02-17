package be.sven.finance.service;

import be.sven.finance.BaseTest;
import be.sven.finance.domain.model.Expense;
import be.sven.finance.domain.repository.ExpenseRepository;
import be.sven.finance.service.mapper.ExpenseMapper;
import be.sven.finance.service.reader.ExpenseReader;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;


class ExpenseServiceTest extends BaseTest {
    private final List<Expense> mockData = createMockData();
    @Mock
    private ExpenseRepository repository;

    @InjectMocks
    private ExpenseService service;

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(mockData);
        assertNotNull(service.findAll());
        assertEquals(mockData, service.findAll());
    }

    @Test
    void findById() {
        String id = mockData.get(0).getId();
        Optional<Expense> actual = Optional.ofNullable(mockData.get(0));
        when(repository.findById(id)).thenReturn(actual);
        assertTrue(service.findById(id).isPresent());
        assertEquals(actual, service.findById(id));
    }
}