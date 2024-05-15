package com.example.InstantShop.service;

import com.example.InstantShop.dto.UserDto;
import com.example.InstantShop.entities.Cart;
import com.example.InstantShop.entities.User;
import com.example.InstantShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public void createUser(UserDto userdto){
        if (userRepository.existsByEmail(userdto.getEmail())){
            throw new IllegalArgumentException("User already exist");
        }
        User user = new User();
        user.setFullName(userdto.getFullName());
        user.setEmail(userdto.getEmail());
        user.setPassword(passwordEncoder.encode(userdto.getPassword()));

        userRepository.save(user);
    }

    public boolean existsByEmail (String email ){
      return  userRepository.existsByEmail(email);
    }
    public Long getIdByEmail (String email){
        Optional <User> optionalUser=userRepository.findByEmail(email);
        if(optionalUser.isPresent()) {
            return optionalUser.get().getId();
        }
        throw new RuntimeException("User does not exist");
    }

    public boolean existsByEmailAndPassword(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);
    }
    public User findByEmail(String email){
        if(userRepository.existsByEmail(email)){
            return userRepository.findByEmail(email).get();
        }
        return null;
    }

    public boolean deleteUserById(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
