package com.example.resource.Repository;

import com.example.resource.Model.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface SignupRepository extends JpaRepository<SignUp,Long> {
}
