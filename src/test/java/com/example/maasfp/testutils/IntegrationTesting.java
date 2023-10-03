package com.example.maasfp.testutils;


import com.example.maasfp.model.Account;
import com.example.maasfp.repository.AccountRepository;
import com.example.maasfp.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class IntegrationTesting {


    /**
     * Test authenticated users able to save to database.
     */

    @Mock
    private AccountRepository repository;
    @Mock
    private AccountService accountService;
    @Mock
    private Account account;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        accountService = new AccountService(repository);

    }

    /**
     * Title: Save Account Test
     * Description: Ensures successful save of Account.
     */

    @Test
    public void testSaveAccount() {
        // Create a new Account object
        account = Account.builder()
                .id(1L)
                .username("foo.bar")
                .accountType("USER")
                .email("foobar@email.com")
                .phone("1234567890")
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .isPaymentSet(true)
                .build();
        //Account newAccount = restTemplate.postForObject("http://localhost:8080/api/accounts", account, Account.class);
        when(repository.save(account)).thenReturn(account);

        // Call the saveAccount method of the accountService
        Account savedAccount = accountService.saveAccount(account);

        // Verify that the repository's saved method was called once with the new account
        verify(repository, times(1)).save(account);

        // Verify that the saved account is not null
        assertNotNull(savedAccount);
    }


    /**
     * Title: Update Account Test
     * Description: Ensure successful account update.
     */
    @Test
    public void testUpdateAccount() {
        // Create an existing Account object
        Account account1 = Account.builder()
                .id(1L)
                .username("sl")
                .accountType("PROVIDER")
                .email("provider@sl.se")
                .phone("9876543210")
                .paymentHistory(10)
                .paymentMethod("post-giro")
                .isPaymentSet(true)
                .build();


        // Mock repo save method to returns updated account
        when(repository.save(account1)).thenReturn(account1);

        // Call accountService.updateAccount method.
        Account updatedAccount = accountService.updateAccountById(Long.valueOf(1), account1);

        // Verify repo save method called with updated account
        verify(repository, times(1)).save(account1);

        // Verify updated account is not null
        assertNotNull(updatedAccount);

        // Verify updated account is same old account
        assertEquals(account1, updatedAccount);
    }

    /**
     * Title: Delete Account Test
     * Description: Ensures successful account removal.
     */
    @Test
    public void testDeleteAccount() {
        // deleteAccount accountService account ID
        account = Account.builder()
                .id(1L)
                .username("foo.bar")
                .accountType("USER")
                .email("foobar@email.com")
                .phone("1234567890")
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .isPaymentSet(true)
                .build();
        repository.deleteById(account.getId());

        verify(repository, times(1)).deleteById(1L);
    }

    /**
     * Title: Get Account Test
     * Description: Ensure successful get account.
     */
    @Test
    public void testGetAccount() {

        account = Account.builder()
                .id(1L)
                .username("foo.bar")
                .accountType("USER")
                .email("foobar@email.com")
                .phone("1234567890")
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .isPaymentSet(true)
                .build();
        // Mock repo findById method to return existing account
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(account));

        // getAccount with ID 1.
        Optional<Account> retrievedAccount = accountService.getAccountById(account.getId());

        // Verify findById finds account with given ID.
        verify(repository, times(1)).findById(1L);

        // Verify retrieved account is not null.
        assertNotNull(retrievedAccount);

        // Verify correct account is retrieved.
        assertEquals(account, retrievedAccount);
    }




}

