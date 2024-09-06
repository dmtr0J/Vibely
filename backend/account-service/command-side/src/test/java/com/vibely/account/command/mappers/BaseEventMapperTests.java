package com.vibely.account.command.mappers;

import com.vibely.account.command.commands.CreateAccountCommand;
import com.vibely.account.command.events.CreateAccountEvent;
import com.vibely.common.model.Role;
import com.vibely.common.model.Status;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BaseEventMapperTests {

    private final EventMapper eventMapper;

//    @Test
//    void toAccount_ValidCreateAccountCommand_MapsToEventWithDefaults() {
//        CreateAccountCommand command = CreateAccountCommand.builder()
//                .username("username")
//                .name("name")
//                .email("email@example.com")
//                .password("password")
//                .dateOfBirth(LocalDate.of(2000, 2, 2))
//                .build();
//
//        CreateAccountEvent event = eventMapper.toEvent(command);
//
//        assertThat(event).isNotNull();
//        assertThat(event.getUsername()).isEqualTo("username");
//        assertThat(event.getName()).isEqualTo("name");
//        assertThat(event.getEmail()).isEqualTo("email@example.com");
//        assertThat(event.getPassword()).isEqualTo("password");
//        assertThat(event.getDateOfBirth()).isEqualTo(LocalDate.of(2000, 2, 2));
//        assertThat(event.getRole()).isEqualTo(Role.USER);
//        assertThat(event.getStatus()).isEqualTo(Status.CREATED);
//        assertThat(event.getId()).isNotNull();
//        assertThat(event.getCreated()).isNotNull();
//    }

}
