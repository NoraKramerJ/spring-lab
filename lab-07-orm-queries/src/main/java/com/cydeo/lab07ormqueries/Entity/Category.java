package com.cydeo.lab07ormqueries.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category extends BaseEntity{

    private String name;

}
