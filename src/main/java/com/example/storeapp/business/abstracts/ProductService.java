package com.example.storeapp.business.abstracts;

import com.example.storeapp.core.utilities.results.DataResult;
import com.example.storeapp.core.utilities.results.Result;
import com.example.storeapp.entities.concretes.Product;
import com.example.storeapp.entities.dtos.ProductWithCategoryDto;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAllByPage(int pageNo, int pageSize);
    DataResult<List<Product>> getAllSorted();
    Result add(Product product);
    DataResult<Product> getByProductName(String productName);
    DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);

    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>>getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
    DataResult<List<ProductWithCategoryDto>> getProductsWithDetails();

}
