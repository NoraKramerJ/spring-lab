package com.cydeo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @RequestMapping("/search-product/{productName}")
    public String searchProduct(@PathVariable(value="productName")  String productName, Model model){

// @PathVariable annotation can be used to handle template variables in the request URI mapping
// , and set them as method parameters.





        return "product/product-list";
    }
}
