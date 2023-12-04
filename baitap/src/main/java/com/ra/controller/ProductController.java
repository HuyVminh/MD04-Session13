package com.ra.controller;

import com.ra.model.service.product.IProductService;
import com.ra.model.service.product.ProductServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
}
