package com.vibely.user.factory;

import com.vibely.common.model.Account;
import com.vibely.common.service.SnowflakeIdGeneratorService;
import com.vibely.user.command.CreateAccountCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserAccountFactoryTest {

    @Autowired
    private UserAccountFactory userAccountFactory;
    @Autowired
    private SnowflakeIdGeneratorService snowflakeIdGeneratorService;

    @Test
    void createAccount() {
    }

    @Test
    void shouldCreateAccountFromCommand() {
        LocalDate dateOfBirth = LocalDate.now();

        CreateAccountCommand command = new CreateAccountCommand(
                "username",
                "name",
                "email@example.com",
                "12345",
                dateOfBirth
        );

        Long accountId = snowflakeIdGeneratorService.generateId().block();

        assert accountId != null;
        Account account = userAccountFactory.createAccountFromCommand(command, accountId);

        assertEquals(accountId, account.getId());
        assertEquals("username", account.getUsername());
        assertEquals("name", account.getName());
        assertEquals("email@example.com", account.getEmail());
        assertEquals("12345", account.getPassword());
        assertEquals(dateOfBirth, account.getDateOfBirth());
    }
}