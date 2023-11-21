package com.example.resource.Repository;

import com.example.resource.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
