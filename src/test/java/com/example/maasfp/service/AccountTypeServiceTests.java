package com.example.maasfp.service;

import com.example.maasfp.model.Account;
import com.example.maasfp.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class AccountTypeServiceTests {

    @Mock
    private AccountRepository repository;
    @Mock
    private AccountService accountService;
    @Mock
    Account account = Account.builder()
            .id(1L)
            .username("foo.bar")
            .accountType("USER")
            .email("foobar@email.com")
            .phone("1234567890")
            .paymentHistory(5)
            .paymentMethod("Credit Card")
            .isPaymentSet(true)
            .build();



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

        //Account newAccount = restTemplate.postForObject("http://localhost:8080/api/accounts", account, Account.class);
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
        // New account with updated values.
        long accountId = account.getId();

        Account account1 = Account.builder()
                .id(accountId)
                .username("torsten.flink")
                .accountType("PROVIDER")
                .email("torsten@flink.com")
                .phone("1234567890")
                .paymentHistory(7)
                .paymentMethod("Swish")
                .isPaymentSet(true)
                .build();


        // Mock repo save method to returns updated account
        when(repository.save(account1)).thenReturn(account1);

        // Call accountService.updateAccount method.
        Account updatedAccount = accountService.updateAccountById(account.getId(), account1);

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
        // Call the deleteAccount method of the accountService with an account ID
        accountService.deleteAccountById(1L);

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

        // Mock the repository's findById method to return the existing account
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(existingAccount));

        // Call the getAccount method of the accountService with an account ID
        Optional<Account> retrievedAccount = accountService.getAccountById(1L);

        // Verify that the repository's findById method was called once with the account ID
        verify(repository, times(1)).findById(1L);

        // Verify that the retrieved account is not null
        assertNotNull(retrievedAccount);

        // Verify that the retrieved account is the same as the existing account
        assertEquals(existingAccount, retrievedAccount);
    }
}