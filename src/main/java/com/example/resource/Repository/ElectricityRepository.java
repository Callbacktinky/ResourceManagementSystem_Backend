package com.example.resource.Repository;

import com.example.resource.Model.Electricity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ElectricityRepository extends JpaRepository<Electricity, Long> {
}
