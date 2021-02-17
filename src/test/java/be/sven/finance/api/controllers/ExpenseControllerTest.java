package be.sven.finance.api.controllers;

import be.sven.finance.BaseTest;
import be.sven.finance.api.exceptions.ExpenseNotFoundException;
import be.sven.finance.service.ExpenseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ExpenseControllerTest extends BaseTest {
    @Mock
    private ExpenseService service;

    @InjectMocks
    private ExpenseController controller;

    @Test
    void throwsException() {
        when(service.findById(any(String.class))).thenReturn(Optional.empty());
        assertThrows(ExpenseNotFoundException.class, () -> controller.findById("unknown_id"));
    }
}