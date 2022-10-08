package com.example.demo.repo;

import com.example.demo.entity.Brands;
import com.example.demo.entity.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableJpaRepositories
@Transactional
public interface BrandRepo extends JpaRepository<Brands,String> {
}
