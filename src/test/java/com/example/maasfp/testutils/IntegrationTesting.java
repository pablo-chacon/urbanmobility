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
        Account account = new Account();
        account.setUsername("FooBar");
        account.setEmail("foo@bar.com");
        account.setPhone("+460666666");
        account.setPaymentHistory(Integer.parseInt("Paid"));
        account.setAccountType("Provider");
        account.setPaymentMethod("Credit Card");

        //Account newAccount = restTemplate.postForObject("http://localhost:8181/api/accounts", account, Account.class);
        when(repository.save(account)).thenReturn(account);

        // Call the saveAccount method of the accountService
        Account savedAccount = accountService.saveAccount(account);

        // Verify that the repository's saved method was called once with the new account
        verify(repository, times(1)).save(account);

        // Verify that the saved account is not null
        assertNotNull(savedAccount);

        // Verify that the saved account is the same as the new account
        assertEquals(account, savedAccount);
    }

    /**
     * Title: Update Account Test
     * Description: Ensure successful account update.
     */
    @Test
    public void testUpdateAccount() {
        // Create an existing Account object
        Account oldAccount = new Account();
        oldAccount.setId(1L);

        // Mock repo save method to returns updated account
        when(repository.save(oldAccount)).thenReturn(oldAccount);

        // Call accountService.updateAccount method.
        Account updatedAccount = accountService.updateAccount(oldAccount);

        // Verify repo save method called with updated account
        verify(repository, times(1)).save(oldAccount);

        // Verify updated account is not null
        assertNotNull(updatedAccount);

        // Verify updated account is same old account
        assertEquals(oldAccount, updatedAccount);
    }

    /**
     * Title: Delete Account Test
     * Description: Ensures successful account removal.
     */
    @Test
    public void testDeleteAccount() {
        // Call the deleteAccount method of the accountService with an account ID
        accountService.deleteAccount(1L);

        // Verify that the repository's deleteById method was called once with the account ID
        verify(repository, times(1)).deleteById(1L);
    }

    /**
     * Title: Get Account Test
     * Description: Ensure successful get account.
     */
    @Test
    public void testGetAccount() {
        // Create an existing Account object
        Account existingAccount = new Account();
        existingAccount.setId(1L);

        // Mock repo findById method to return existing account
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(existingAccount));

        // getAccount with ID 1.
        Optional<Account> retrievedAccount = accountService.getAccountById(1L);

        // Verify findById finds account with given ID.
        verify(repository, times(1)).findById(1L);

        // Verify retrieved account is not null.
        assertNotNull(retrievedAccount);

        // Verify correct account is retrieved.
        assertEquals(existingAccount, retrievedAccount);
    }

    public void runIntegrationTests() {

        IntegrationTesting integrationTesting = new IntegrationTesting();
        integrationTesting.testSaveAccount();
        integrationTesting.testUpdateAccount();
        integrationTesting.testDeleteAccount();
        integrationTesting.testGetAccount();
    }
}

