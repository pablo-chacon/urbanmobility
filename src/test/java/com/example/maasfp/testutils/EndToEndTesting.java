package com.example.maasfp.testutils;

import com.example.maasfp.model.Account;
import com.example.maasfp.repository.AccountRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * AccountController end-to-end endpoint tests.
 */
public class EndToEndTesting {



    @SpringBootTest
    @AutoConfigureMockMvc
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    class AccountTypeControllerTest {

        @Autowired
        private MockMvc mvc;

        @Autowired
        private AccountRepository accountRepository;

        @Mock
        private Account account;

        private String jsonAccount;

        @BeforeEach
        public void setup() throws JsonProcessingException {

            // Variable
            account = Account.builder()
                    .username("Foo")
                    .accountType("user")
                    .email("foo@bar.com")
                    .phone("+4670666666")
                    .paymentHistory(0)
                    .paymentMethod("Credit Card")
                    .isPaymentSet(true)
                    .build();

            ObjectMapper mapper = new ObjectMapper();
            jsonAccount = mapper.writeValueAsString(account);
        }

        @AfterEach
        public void cleanUp(){
            accountRepository.deleteAll();
        }

        @Test
        @DisplayName("post endpoint returns code 201 account.")
        public void PostEndPointReturnsCreationStatus() throws Exception {
            mvc.perform(MockMvcRequestBuilders
                            .post("/api/account")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonAccount)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id", Matchers.is(1)))
                    .andExpect(jsonPath("$.username", Matchers.is("Foo")))
                    .andExpect(jsonPath("$.email", Matchers.is("foo@bar.com")));

        }

        @Test
        @DisplayName("post endpoint returns code 409, conflict")
        public void PostEndPointReturnIfConflict() throws Exception {
            // Arrange
            accountRepository.save(account);

            // Act
            mvc.perform(MockMvcRequestBuilders
                            .post("/api/account")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonAccount)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isConflict());
        }

        @Test
        @DisplayName("delete endpoint returns 200, OK")
        public void DeleteEndpointReturnsOk() throws Exception {
            // Arrange
            accountRepository.save(account);
            // Act
            mvc.perform(MockMvcRequestBuilders
                            .delete("/api/account/{accountId}", 1L))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Account successfully removed"));
        }

        @Test
        @DisplayName("endpoint returns code 409, conflict")
        public void DeleteEndPointReturnsNotFound() throws Exception {
            mvc.perform(MockMvcRequestBuilders
                            .delete("/api/account/{accountId}", 1L))
                    .andExpect(status().isNotFound());
        }

        @Test
        @DisplayName("Update endpoint, /api/account/{accountId}")
        public void PutEndpointReturnsOkUpdatedAccount() throws Exception {
            // Arrange
            accountRepository.save(account);

            // Act
            mvc.perform(MockMvcRequestBuilders
                            .put("/api/account/{accountId}", 1L)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonAccount)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id", Matchers.is(1)))
                    .andExpect(jsonPath("$.username", Matchers.is("Foo")))
                    .andExpect(jsonPath("$.email", Matchers.is("foo@bar.com")));
        }

        @Test
        @DisplayName("update endpoint /api/account/{accountId}")
        public void PutEndPointReturnsNotFound() throws Exception {
            mvc.perform(MockMvcRequestBuilders
                            .put("/api/account/{accountId}", 1L)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonAccount)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());
        }
    }
    @Test
    public void runEndToEndTests() {
        System.out.println("Running end-to-end tests...");
    }
}
