package com.example.demo.model;

import lombok.*;
import org.joda.money.Money;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_COFFEE")
@Builder
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee extends BaseEntity {
    private String name;


    private Money price;
}
