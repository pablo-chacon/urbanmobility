package com.example.maasfp.controller;

import com.example.maasfp.controller.AccountController;
import com.example.maasfp.model.Account;
import com.example.maasfp.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccountControllerTests {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Title: Save Account Test
     * Description: Ensures saveAccount method returns saved account.
     */
    @Test
    public void testSaveAccount() {
        // Create a mock Account object
        Account account = Account.builder()
                .username("Josef")
                .contactInfo("112")
                .accountType("ADMIN")
                .paymentInfo("112")
                .build();

        // Create a mock Account object returned by the accountService.saveAccount()
        Account savedAccount = Account.builder()
                .id(1L)
                .username("Josef")
                .contactInfo("112")
                .accountType("ADMIN")
                .paymentInfo("112")
                .build();

        // Mock the accountService.saveAccount() method to return savedAccount object
        when(accountService.saveAccount(account)).thenReturn(savedAccount);

        // Call the saveAccount method.
        Account result = accountController.saveAccount();

        // Verify accountService.saveAccount() called with correct account object
        verify(accountService, times(1)).saveAccount(account);

        // Verify that the result is equal to the savedAccount object
        assertEquals(savedAccount, result, "The saveAccount method did not return the correct account object.");
    }

    /**
     * Title: Null Account Test
     * Description: Ensures exception is thrown if account object is null.
     */
    @Test
    public void testSaveAccountNullAccount() {
        // Call the saveAccount method in the AccountController with a null account object
        assertThrows(NullPointerException.class, () -> {
            accountController.saveAccount();
        }, "Expected an exception when the account object is null.");
    }
}
