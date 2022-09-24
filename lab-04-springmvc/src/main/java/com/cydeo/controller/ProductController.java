package com.cydeo.controller;


import com.cydeo.lab04springmvc.model.Product;
import com.cydeo.lab04springmvc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/search-product/{productName}")
    public String searchProduct(@PathVariable(value="productName")
           String productName, Model model){

// @PathVariable annotation can be used to handle template variables in the request URI mapping
// , and set them as method parameters.


model.addAttribute("productList",
        productService.searchProduct(productName) );



        return "product/product-list";
    }
}
