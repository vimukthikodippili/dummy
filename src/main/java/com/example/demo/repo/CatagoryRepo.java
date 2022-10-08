package com.example.demo.repo;

import com.example.demo.entity.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableJpaRepositories
@Transactional
public interface CatagoryRepo extends JpaRepository<Catagory,String> {
    @Query(value = "SELECT code FROM catagory\n" +
            "where code like ?%\n" +
            "order by cast(substring(code,?) as unsigned) desc limit 1;\n", nativeQuery = true)
    String findLastId(String prefix, int value);
}
