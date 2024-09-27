package com.gilasw.notification.controller;

import com.gilasw.notification.controller.dto.UserDTO;
import com.gilasw.notification.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import static com.gilasw.notification.mapper.UserMapper.userMapper;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<UserDTO> getUserAll() {
        return userService.findAllUsers().stream().map(userMapper).toList();
    }
}
