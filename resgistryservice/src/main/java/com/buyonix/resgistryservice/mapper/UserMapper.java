package com.buyonix.resgistryservice.mapper;

import com.buyonix.resgistryservice.dto.UserDTO;
import com.buyonix.resgistryservice.model.User;
import com.buyonix.resgistryservice.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User toEntity(UserDTO userDTO);
    UserResponse toResponse(User user);
}
