package com.example.demo.entity;

import com.example.demo.enums.Types;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Products {
    @Id
    @Column(length = 45, name = "product_id")
    private String productId;

    @Column(name = "code", columnDefinition = "INT", nullable = false)
    private int code;



    @Type(type = "json")
    @Column(columnDefinition = "json")
    private ArrayList productValues;



   @Type(type = "json")
    @Column(columnDefinition = "json")
    private ArrayList validators;

    @Column(length = 45, name = "label")
    private String label;

    @OneToMany(mappedBy="product")
    private Set<Brands> brands;

    @OneToOne(mappedBy = "products")
    private Conditon conditon;

    @OneToOne(mappedBy = "products")
    private Edition edition;




}
