package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.Entity.Order;
import com.cydeo.lab07ormqueries.Entity.Payment;
import com.cydeo.lab07ormqueries.enums.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    //Write a derived query to get top 5 orders by order by total price desc
    List<Order> findTop5ByOrderByTotalPriceDesc();
    //Write a derived query to get all orders by specific customer email
    List<Order> findAllByCustomer_Email(String email);
    //Write a derived query to get all orders by specific payment method
    List<Order> findAllByPaymentPaymentMethod(PaymentMethod paymentmethod);

    //Write a derived query to check is there any orders by customer email
    boolean existsByCustomerEmail(String email);
    //Write a native query to get all orders by specific product name
  @Query(value="select * from orders o join cart c on o.cart_id=c.cart_id" +
          "  Join cart_item ci on ci.cart_id=c.id " +
          "Join product p on ci.product_id=p.id where p.name=?1",nativeQuery = true)
    List<Order> retrieveAllOrderByProductName(@Param("name")String name);
    //Write a native query to get all orders by specific categoryId
    @Query(value = "SELECT * FROM orders o JOIN cart c ON o.cart_id = c.id" +
            "JOIN cart_item ci ON ci.cart_id = c.id" +
            "JOIN product p ON ci.product_id = p.id" +
            "JOIN category ca ON ca.id = p.c_id" +
            "WHERE ca.id = ?1", nativeQuery = true)
    List<Order> retrieveAllByCategoryId(@Param("id") Long id);
    //Write a JPQL derived query to get all orders by totalPrice and paidPrice are equals
    @Query("select o from Order o where o.totalPrice= o.paidPrice")
    List<Order> retrieveAllOrdersBetweenTotalPriceAndPaidPriceIsSame();

    //Write JPQL query to get all orders by totalPrice and paidPrice are not equals and discount is not null
    @Query("select o from Order o where o.paidPrice<>o.totalPrice And o.cart.discount is NOT Null")
    List<Order> findAllByPaidPriceAndTotalPriceAreNotEqualAndDiscountIsNull();


}
