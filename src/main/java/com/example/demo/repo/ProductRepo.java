package com.example.demo.repo;

import com.example.demo.entity.Products;
import com.example.demo.entity.customerInterface.ProductInterface;
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

    @Query(value = "\n" +
            "SELECT products.product_id AS productId,products.conditions AS conditions,products.label AS label, products.type AS types,products.validators AS validators,products.value AS valuess,brands.label AS brandLabel,brands.required AS required,brands.tool_tip AS toolTip,brands.code AS codesd FROM products JOIN brands ON products.product_id=brands.product_id AND products.code LIKE %?1%", nativeQuery = true)
   // @Query(value = "select * from products where code=?1",nativeQuery = true)
    List<ProductInterface> getAllProduct(String searchText);
}
//    String getProductId();
//    boolean getConditions();
//    double getValues();
//    String getTypes();
//    ArrayList getValidators();
//    String getLabel();
//    String getBrandLabel();
//    Byte getRequired();
//    String getToolTip();
//    Integer getCode();