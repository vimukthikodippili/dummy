package com.example.demo.repo;

import com.example.demo.entity.Conditon;
import com.example.demo.entity.Edition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableJpaRepositories
@Transactional
public interface ConditionRepo extends JpaRepository<Conditon,String> {
}
