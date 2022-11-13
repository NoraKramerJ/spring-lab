package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.Entity.Discount;
import com.cydeo.lab07ormqueries.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {
    //Write a derived query to get discount by name

  Discount findByName(String name);

    //Write a derived query to get all discounts greater than discount amount

    List<Discount> findAllByDiscountGreaterThan(BigDecimal Amount);

    //Write a derived query to get all discounts by specific discount type
    List<Discount> findAllByDiscountType(DiscountType discountType);
    //Write a JPQL query to get all discounts amount between range of discount amount
    @Query(value="select d from Discount d where d.discount between  ?1 And ?2")
    List<Discount> findAllByRangeBetweenAmount(BigDecimal startAmount,BigDecimal endAmount);
}
