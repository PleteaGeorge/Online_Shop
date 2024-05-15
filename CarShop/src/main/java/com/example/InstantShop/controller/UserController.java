package com.example.InstantShop.controller;

import com.example.InstantShop.dto.UserDto;
import com.example.InstantShop.service.UserService;
import com.example.InstantShop.validator.AccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private AccountValidator accountValidator;
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome(){
        return "home";
    }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(){
        return "user";
    }
    @GetMapping("/register")
    public String getRegistration(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "registration";
    }
    @PostMapping("/register")
    public String postRegister(@ModelAttribute(value = "userDto") UserDto userDto){
        if(!accountValidator.verifyRegister(userDto))
            return "redirect:/register";
        userService.createUser(userDto);
        return "redirect:/login";
    }
    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        if(userService.deleteUserById(id)){
            System.out.println("this user has been deleted");
        }
         else System.out.println("user not found");
    }
    @GetMapping("/login")
    public String getloginPage(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto",userDto);
        return "login";
    }

}
