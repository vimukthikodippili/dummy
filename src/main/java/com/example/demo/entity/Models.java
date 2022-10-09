package com.example.demo.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "models")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Models {
    @Id
    @Column(length = 45, name = "model_id")
    private String modelId;

    @Column(length = 45, name = "models")
    private String models;
}
