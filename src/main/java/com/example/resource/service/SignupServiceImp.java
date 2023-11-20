package com.example.resource.service;

import com.example.resource.Exception.ResourceNotFoundException;
import com.example.resource.Model.SignUp;
import com.example.resource.Repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class SignupServiceImp implements SignupService{

    @Autowired
    private SignupRepository signupRepository;

    @Autowired
    public SignupServiceImp(SignupRepository signupRepository) {
        super();
        this.signupRepository = signupRepository;
    }
    @Override
    public SignUp saveSignUp(SignUp signUp) {
        return signupRepository.save(signUp);
    }

    @Override
    public List<SignUp> getAllSignUp() {
        return signupRepository.findAll();
    }

    @Override
    public SignUp getSignUpById(long id) {
        return signupRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("SignUp", "Id", id));
    }

    @Override
    public SignUp updateSignUp(SignUp signUp, long id) {
        SignUp existingSignUp = signupRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("SignUp", "Id", id));

        existingSignUp.setFirstName(signUp.getFirstName());
        existingSignUp.setLastName(signUp.getLastName());
        existingSignUp.setPhoneNumber(signUp.getPhoneNumber());
        existingSignUp.setPassword(signUp.getPassword());

        signupRepository.save(existingSignUp);
        return existingSignUp;
    }

    @Override
    public void deleteSignUp(long id) {
        signupRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("SignUp", "Id", id));
        signupRepository.deleteById(id);

    }
}
