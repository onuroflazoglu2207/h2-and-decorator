package com.example.demo.mapper;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserRequestDTO.UserRequestDTOBuilder;
import com.example.demo.model.UserModel;
import com.example.demo.model.UserModel.UserModelBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-22T13:52:12+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class UserRequestMapperImpl implements UserRequestMapper {

    @Override
    public UserRequestDTO toUserRequestDTO(UserModel user) {
        if ( user == null ) {
            return null;
        }

        UserRequestDTOBuilder userRequestDTO = UserRequestDTO.builder();

        userRequestDTO.name( user.getName() );
        userRequestDTO.birthday( user.getBirthday() );
        userRequestDTO.gender( user.getGender() );
        userRequestDTO.email( user.getEmail() );
        userRequestDTO.phone( user.getPhone() );
        userRequestDTO.password( user.getPassword() );

        return userRequestDTO.build();
    }

    @Override
    public List<UserRequestDTO> toUserRequestDTOs(List<UserModel> users) {
        if ( users == null ) {
            return null;
        }

        List<UserRequestDTO> list = new ArrayList<UserRequestDTO>( users.size() );
        for ( UserModel userModel : users ) {
            list.add( toUserRequestDTO( userModel ) );
        }

        return list;
    }

    @Override
    public UserModel toUserModel(UserRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserModelBuilder userModel = UserModel.builder();

        userModel.name( dto.getName() );
        userModel.birthday( dto.getBirthday() );
        userModel.gender( dto.getGender() );
        userModel.email( dto.getEmail() );
        userModel.phone( dto.getPhone() );
        userModel.password( dto.getPassword() );

        return userModel.build();
    }

    @Override
    public List<UserModel> toUserModels(List<UserRequestDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<UserModel> list = new ArrayList<UserModel>( dtos.size() );
        for ( UserRequestDTO userRequestDTO : dtos ) {
            list.add( toUserModel( userRequestDTO ) );
        }

        return list;
    }
}
