package com.cydeo.lab07ormqueries.repository;
import com.cydeo.lab06orm.enums.DiscountType;
import com.cydeo.lab07ormqueries.Entity.Cart;
import com.cydeo.lab07ormqueries.Entity.Customer;
import com.cydeo.lab07ormqueries.enums.CartState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    //Write a derived query to get all cart by specific discount type
    List<Cart> findAllByDiscountDiscountType(DiscountType discountType);
    //Write a JPQL query to get all cart by customer
    @Query("select c from Cart c where c.customer.id=?1")
    List<Cart> retrieveAllCartByCustomer(Long id);
    //Write a derived query to get all cart by customer and cart state
    List<Cart> findAllByCustomer_IdAndCartState(Long id, CartState cartState);
    //Write a derived query to get all cart by customer and cart state and discount is null condition
    List<Cart> findAllByCustomer_IdAndCartStateAndDiscountIsNull(Long id,CartState cartState);
    //Write a native query to get all cart by customer and cart state and discount is not null condition
    @Query(value="Select * from  cart c join customer cu on c.customer_id=cu.id where c.cart_state=?1" +
            " And cu.id=?1 AND discount.id<>Null ",nativeQuery = true)
    List<Cart> findAllByCustomerIdAndCartStateAndDiscountIsNotNull(String cartState,Long id);
}
