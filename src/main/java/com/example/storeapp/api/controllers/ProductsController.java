package com.example.storeapp.api.controllers;

import com.example.storeapp.business.abstracts.ProductService;
import com.example.storeapp.core.utilities.results.DataResult;
import com.example.storeapp.core.utilities.results.Result;
import com.example.storeapp.entities.concretes.Product;
import com.example.storeapp.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;
    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/getAll")
    public DataResult<List<Product>>getAll(){
        return productService.getAll();
    }
    @PostMapping("/add")
    public Result  add(@RequestBody Product product){
        return productService.add(product);
    }
    @GetMapping("/getByProductName")
    public DataResult<Product> getProductName(@RequestParam String productName){
        return productService.getByProductName(productName);
    }
    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getProductNameAndCategoryId(@RequestParam String productName,@RequestParam int  categoryId){
        return productService.getByProductNameAndCategoryId(productName,categoryId);
    }
    @GetMapping("/getByPrdoductNameOrCategpryId")
    public DataResult<List<Product>> getProductNameOrCategpryId(@RequestParam String productName,@RequestParam int categoryId){
        return productService.getByProductNameOrCategoryId(productName,categoryId);
    }
    @GetMapping("getByCategoryId")
    public DataResult<List<Product>> getByCategoryIdIn(@RequestParam List<Integer> categories){
        return productService.getByCategoryIdIn(categories);
    }
    @GetMapping("getByProductNameContains")
    public DataResult<List<Product>> getProductNameContains(@RequestParam String productName){
        return productService.getByProductNameContains(productName);
    }
    @GetMapping("getByNameStartsWith")
    public DataResult<List<Product>> getByStartsWith(@RequestParam String productName){
        return productService.getByProductNameStartsWith(productName);
    }
    @GetMapping("getByNameCategory")
    public DataResult<List<Product>> getByNameCategory(@RequestParam String productName,@RequestParam int  categoryId){
        return productService.getByNameAndCategory(productName,categoryId);
    }
    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAllByPage(@RequestParam int pageNo, @RequestParam int pageSize){
        return productService.getAllByPage(pageNo,pageSize);
    }
    @GetMapping("/getAllAsc")
    public DataResult<List<Product>> getAllSorted(){
        return productService.getAllSorted();
    }
    @GetMapping("getProductsWithDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductsWithDetails(){
        return productService.getProductsWithDetails();

    }


}
