package com.cydeo.lab06orm.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String street;
    private String zip_code;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
