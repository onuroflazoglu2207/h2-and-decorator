package com.example.demo.service;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.mapper.UserRequestMapper;
import com.example.demo.mapper.UserResponseMapper;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserResponseMapper responseMapper;
    private final UserRequestMapper requestMapper;

    @Override
    public List<UserResponseDTO> getAll() {
        return responseMapper.toUserResponseDTOs(repository.findAll());
    }

    @Override
    public UserResponseDTO getById(Long identity) {
        Optional<UserModel> optional = repository.findById(identity);
        return optional.isEmpty() ? null : responseMapper.toUserResponseDTO(optional.get());
    }

    @Override
    public UserResponseDTO save(UserRequestDTO dto) {
        try {
            UserModel model = requestMapper.toUserModel(dto);
            model = repository.save(model);
            return responseMapper.toUserResponseDTO(model);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserResponseDTO update(UserRequestDTO dto, Long identity) {
        try {
            Optional<UserModel> optional = repository.findById(identity);
            UserModel model = optional.isEmpty() ? null : optional.get();
            if (model == null) return null;
            UserModel temp = requestMapper.toUserModel(dto);
            temp.setIdentity(identity);
            repository.save(temp);
            return responseMapper.toUserResponseDTO(model);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserResponseDTO delete(Long identity) {
        Optional<UserModel> optional = repository.findById(identity);
        UserModel model = optional.isEmpty() ? null : optional.get();
        if (model != null) repository.deleteById(identity);
        return responseMapper.toUserResponseDTO(model);
    }
}
