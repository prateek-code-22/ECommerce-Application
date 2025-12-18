package com.app.ecommerceapplication.service;
import com.app.ecommerceapplication.dto.AddressDTO;
import com.app.ecommerceapplication.dto.UserResponse;
import com.app.ecommerceapplication.repository.UserRepository;
import com.app.ecommerceapplication.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // to define the default constructor for userRepo interface
public class UserService {

    private final UserRepository userRepository;
//    private List<User> userList = new ArrayList<>();
//    private Long nextId = 1L;


    //list all users
    public List<UserResponse> fetchAllUser(){
        return userRepository.findAll().stream().map(this::mapToUserResponse).collect(Collectors.toList());
    }

    //add user
    public void addUser(User user){
        userRepository.save(user);
    }

    //fetch user using java stream
    public Optional<User> fetchUser(Long id) {
//        return userList.stream()
//                .filter(user -> user.getId().equals(id))
//                .findFirst();
            return userRepository.findById(id);
    }

    //update detail of user
    public boolean updateUser(Long id, User updatedUser) {
            return userRepository.findById(id)
                    .map(existingUser -> {
                        existingUser.setFirstName(updatedUser.getFirstName());
                        existingUser.setLastName(updatedUser.getLastName());
                        userRepository.save(existingUser);
                        return true;
                    }).orElse(false);
    }

    private UserResponse mapToUserResponse(User user){
        UserResponse response = new UserResponse();
        response.setId(String.valueOf(user.getId()));
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setRole(user.getRole());

        if(user.getAddress() != null){
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setStreet(user.getAddress().getStreet());
            addressDTO.setCity(user.getAddress().getCity());
            addressDTO.setState(user.getAddress().getState());
            addressDTO.setCountry(user.getAddress().getCountry());
            addressDTO.setZipcode(user.getAddress().getZipcode());
            response.setAddress(addressDTO);
        }
        return response;
    }
}
