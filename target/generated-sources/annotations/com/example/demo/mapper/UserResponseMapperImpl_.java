package com.example.demo.mapper;

import com.example.demo.dto.UserResponseDTO;
import com.example.demo.dto.UserResponseDTO.UserResponseDTOBuilder;
import com.example.demo.model.UserModel;
import com.example.demo.model.UserModel.UserModelBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-22T13:52:12+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
@Qualifier("delegate")
public class UserResponseMapperImpl_ implements UserResponseMapper {

    @Override
    public UserResponseDTO toUserResponseDTO(UserModel user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDTOBuilder userResponseDTO = UserResponseDTO.builder();

        userResponseDTO.name( user.getName() );
        userResponseDTO.birthday( user.getBirthday() );
        userResponseDTO.gender( user.getGender() );
        userResponseDTO.email( user.getEmail() );
        userResponseDTO.phone( user.getPhone() );
        userResponseDTO.password( user.getPassword() );

        return userResponseDTO.build();
    }

    @Override
    public List<UserResponseDTO> toUserResponseDTOs(List<UserModel> users) {
        if ( users == null ) {
            return null;
        }

        List<UserResponseDTO> list = new ArrayList<UserResponseDTO>( users.size() );
        for ( UserModel userModel : users ) {
            list.add( toUserResponseDTO( userModel ) );
        }

        return list;
    }

    @Override
    public UserModel toUserModel(UserResponseDTO dto) {
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
    public List<UserModel> toUserModels(List<UserResponseDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<UserModel> list = new ArrayList<UserModel>( dtos.size() );
        for ( UserResponseDTO userResponseDTO : dtos ) {
            list.add( toUserModel( userResponseDTO ) );
        }

        return list;
    }
}
