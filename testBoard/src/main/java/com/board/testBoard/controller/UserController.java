package com.board.testBoard.controller;

import com.board.testBoard.dto.UserForm;
import com.board.testBoard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@ResponseBody
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public void signUpUser(@RequestBody @Valid UserForm userForm) throws Exception {
        userService.signUpUser(userForm);
    }
}
