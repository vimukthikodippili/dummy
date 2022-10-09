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
@Table(name = "conditions")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Conditon {
    @Id
    @Column(length = 45, name = "condition_id")
    private String conditionId;

    @Column(name = "conditions", nullable = false, columnDefinition = "TINYINT")
    @NotNull(message = "active state Type is mandatory")
    private boolean conditions;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_condition_id", referencedColumnName = "product_id")
    private Products products;
}
