package com.example.InstantShop.validator;

import com.example.InstantShop.dto.UserDto;
import com.example.InstantShop.entities.User;
import com.example.InstantShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AccountValidator {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private static String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static String nameRegex = "([a-zA-Z_\s]+)";
    @Autowired
    private UserService userService;
    public boolean verifyRegister(UserDto userDto) {
        if(userService.existsByEmail(userDto.getEmail())){
            return false;
        }
        if (!userDto.getEmail().matches(emailRegex)) {
            return false;
        }
        if(!userDto.getFullName().matches(nameRegex)){
            return false;
        }
        return userDto.getPassword().length() >= 5;

    }
    public boolean verifyLogin(UserDto userDto){
        User user = userService.findByEmail(userDto.getEmail());
        if(user == null){
            return false;
        }
        return passwordEncoder.matches(userDto.getPassword(), user.getPassword());
    }
}