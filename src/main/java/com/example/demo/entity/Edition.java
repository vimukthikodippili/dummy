package com.example.demo.entity;

import com.example.demo.enums.Types;
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
@Table(name = "edition")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Edition {
    @Id
    @Column(length = 45, name = "edition_id")
    private String editionId;

    @Column(name = "type",columnDefinition = "VARCHAR(45)")
    @NotNull(message = "ExtraState is required")
    @Enumerated(EnumType.STRING)
    private Types types;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_edition_id", referencedColumnName = "product_id")
    private Products products;
}
