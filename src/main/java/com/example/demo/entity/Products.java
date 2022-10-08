package com.example.demo.entity;

import com.example.demo.enums.Types;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @Column(name = "conditions", nullable = false, columnDefinition = "TINYINT")
    @NotNull(message = "active state Type is mandatory")
    private boolean conditions;

    @Column(name = "value",columnDefinition = "DOUBLE")
    @NotNull(message = "Hourly cost is required")
    private double values;

    @Column(name = "type",columnDefinition = "VARCHAR(45)")
    @NotNull(message = "ExtraState is required")
    @Enumerated(EnumType.STRING)
    private Types types;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private ArrayList validators;

    @Column(length = 45, name = "label")
    private String label;

    @OneToMany(mappedBy="product")
    private Set<Brands> brands;




}
