package com.example.demo.model;

import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

import javax.persistence.*;

@Entity
@Table(name = "T_COFFEE")
@Builder
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Column
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmount",
            parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")})
    private Money price;


}
