package com.board.testBoard.service;

import com.board.testBoard.domain.User;
import com.board.testBoard.dto.UserForm;
import com.board.testBoard.exception.DuplicateEmailException;
import com.board.testBoard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void signUpUser(UserForm userForm) throws Exception {
        validateDuplicateEmail(userForm.getEmail());
        userRepository.save(User.createUser(userForm));
    }

    private void validateDuplicateEmail(String email) throws Exception{
        if(userRepository.existsByEmail(email)) {
            throw new DuplicateEmailException();
        }
    }
}
