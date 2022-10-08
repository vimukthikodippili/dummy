package com.example.demo.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "brands")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Brands {
    @Id
    @Column(length = 45, name = "brand_id")
    private String brandId;

    @Column(length = 45, name = "label")
    private String label;


    @Column(name = "required", nullable = false, columnDefinition = "TINYINT")
    @NotNull(message = "active state Type is mandatory")
    private boolean required;

    @Column(length = 45, name = "tool_tip")
    private String toolTip;

    @Column(name = "code", columnDefinition = "INT", nullable = false)
    private int code;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Products  product;
}
