package com.vibely.account.command.mapper;

import com.vibely.account.command.command.CreateAccountCommand;
import com.vibely.account.command.event.CreateAccountEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapper {

    @Mapping(target = "role", expression = "java(com.vibely.common.model.Role.USER)")
    @Mapping(target = "status", expression = "java(com.vibely.common.model.Status.CREATED)") // Assuming default status is ACTIVE
    CreateAccountEvent toEvent(CreateAccountCommand command);
}
