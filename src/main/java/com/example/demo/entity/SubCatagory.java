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
@Table(name = "sub_catagory")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class SubCatagory {
    @Id
    @Column(length = 45, name = "sub_catagory_id")
    private String subCatagoryId;

    @Column(length = 45, name = "sub_catagory_name")
    private String subCatagoryName;

    @Column(name = "code", columnDefinition = "INT", nullable = false)
    private int code;
}
