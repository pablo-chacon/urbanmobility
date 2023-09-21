package com.example.maasfp.service;

import com.example.maasfp.model.Account;
import com.example.maasfp.repository.AccountRepository;
import com.example.maasfp.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccountServiceTests {

    @Mock
    private AccountRepository repository;

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
        Account newAccount = new Account("John Doe", "john@example.com");

        // Mock the repository's save method to return the new account
        when(repository.save(newAccount)).thenReturn(newAccount);

        // Call the saveAccount method of the accountService
        Account savedAccount = accountService.saveAccount(newAccount);

        // Verify that the repository's save method was called once with the new account
        verify(repository, times(1)).save(newAccount);

        // Verify that the saved account is not null
        assertNotNull(savedAccount);

        // Verify that the saved account is the same as the new account
        assertEquals(newAccount, savedAccount);
    }

    /**
     * Title: Update Account Test
     * Description: Ensure successful account update.
     */
    @Test
    public void testUpdateAccount() {
        // Create an existing Account object
        Account oldAccount = new Account("John Doe", "john@example.com");
        oldAccount.setId(1L);

        // Mock the repository's save method to return the updated account
        when(repository.save(oldAccount)).thenReturn(oldAccount);

        // Call the updateAccount method of the accountService
        Account updatedAccount = accountService.updateAccount(oldAccount);

        // Verify that the repository's save method was called once with the updated account
        verify(repository, times(1)).save(oldAccount);

        // Verify that the updated account is not null
        assertNotNull(updatedAccount);

        // Verify that the updated account is the same as the old account
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
        Account existingAccount = new Account("John Doe", "john@example.com");
        existingAccount.setId(1L);

        // Mock the repository's findById method to return the existing account
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(existingAccount));

        // Call the getAccount method of the accountService with an account ID
        Account retrievedAccount = accountService.getAccount(1L);

        // Verify that the repository's findById method was called once with the account ID
        verify(repository, times(1)).findById(1L);

        // Verify that the retrieved account is not null
        assertNotNull(retrievedAccount);

        // Verify that the retrieved account is the same as the existing account
        assertEquals(existingAccount, retrievedAccount);
    }
}