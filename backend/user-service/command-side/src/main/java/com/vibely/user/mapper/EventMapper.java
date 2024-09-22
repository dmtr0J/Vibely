package com.vibely.user.mapper;

import com.vibely.user.command.CreateAccountCommand;
import com.vibely.user.event.CreateAccountEvent;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapper {

    //@Mapping(target = "role", expression = "java(com.vibely.common.entity.Role.USER)")
    //@Mapping(target = "status", expression = "java(com.vibely.common.entity.Status.CREATED)") // Assuming default status is ACTIVE
    CreateAccountEvent toEvent(CreateAccountCommand command);
}
