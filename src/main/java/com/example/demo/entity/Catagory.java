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
@Table(name = "catagory")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Catagory {
    @Id
    @Column(length = 45, name = "catagory_id")
    private String catagoryId;

    @Column(length = 45, name = "catagory_name")
    private String catagoryName;


}
