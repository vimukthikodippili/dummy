package com.example.demo.repo;

import com.example.demo.entity.Products;
import com.example.demo.entity.customerInterface.ProductInterface;
import com.example.demo.enums.Types;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@EnableJpaRepositories
@Transactional
public interface ProductRepo  extends JpaRepository<Products,String> {

//    @Query(value = "\n" +
//            "SELECT products.label AS id,products.conditions AS conditions,products.label AS label, products.type AS type,products.validators AS validators,products.product_values AS valuess,brands.label AS brandLabel,brands.required AS required,brands.tool_tip AS toolTip,brands.code AS codesd FROM products JOIN brands ON products.product_id=brands.product_id AND products.code LIKE %?1%", nativeQuery = true)
    //@Query(value = "select products.label as id,products.label as label, products.product_values as valuess,products.type as type from products where products.code LIKE %?1%",nativeQuery = true)
    @Query(value = "select products.label as label,brands.label as brandlabel,conditions.conditions as conditions,edition.type as types FROM products,conditions,edition,brands where products.product_id=brands.product_id AND products.product_id = conditions.product_condition_id and products.product_id = edition.product_edition_id AND products.code LIKE %?1%",nativeQuery = true)
    List<ProductInterface> getAllProduct(String searchText);
}




