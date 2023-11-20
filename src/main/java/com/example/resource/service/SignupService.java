package com.example.resource.service;

import com.example.resource.Model.SignUp;

import java.util.List;

public interface SignupService {

    SignUp saveSignUp(SignUp signUp);
    List<SignUp> getAllSignUp();
    SignUp getSignUpById(long id );
    SignUp updateSignUp(SignUp signUp, long id);
    void deleteSignUp(long id);

}
