package com.cydeo.lab07ormqueries.repository;


import com.cydeo.lab07ormqueries.Entity.Balance;
import com.cydeo.lab07ormqueries.Entity.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository<Balance,Long> {
    //Write a derived query to check balance exists for specific customer
boolean existsBalanceByCustomer(Customer customer);
//another way
    boolean existCustomerId(Long id);
    //Write a derived query to get balance for specific customer
    Balance findByCustomer(Customer customer);
    //or
    Balance findByCustomerId(Long id);

    //Write a native query to get top 5 max balance
 @Query(value="select  * from balance order by amount desc limit 5",nativeQuery = true)
    List<Balance> retrieveTop5Amount();
    //Write a derived query to get all balances greater than or equal specific balance amount
    List<Balance> findAllByAmountGreaterThanEqual(BigDecimal amount);
    //Write a native query to get all balances less than specific balance amount
    @Query(value="select  * from balance where amount < ?1",nativeQuery = true)
    List<Balance> retrieveBalanceLessThanAmount(@Param("amount") BigDecimal amount);
}
