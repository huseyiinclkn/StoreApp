package com.example.storeapp.business.concretes;

import com.example.storeapp.business.abstracts.ProductService;
import com.example.storeapp.core.utilities.results.DataResult;
import com.example.storeapp.core.utilities.results.Result;
import com.example.storeapp.core.utilities.results.SuccessDataResult;
import com.example.storeapp.core.utilities.results.SuccessResult;
import com.example.storeapp.dataAccess.abstracts.ProductRepository;
import com.example.storeapp.entities.concretes.Product;
import com.example.storeapp.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>
                (this.productRepository.findAll(), "Data listelendi.");
    }

    @Override
    public Result add(Product product) {
        this.productRepository.save(product);
        return new SuccessResult("Ürün eklendi.");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>
                (this.productRepository.getByProductName(productName), "Data listelendi.");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>
                (this.productRepository.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data listelendi.");
    }


    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (this.productRepository.getByProductNameOrCategory_CategoryId(productName,categoryId), "Data listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByCategoryIn(categories), "Data listelendi.");
    }


    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productRepository.getByProductNameContains(productName), "Data listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productRepository.getByProductNameStartsWith(productName), "Data listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
        (this.productRepository.getByNameAndCategory(productName, categoryId), "Data listelendi.");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductsWithDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>
         (this.productRepository.getProductsWithDetails(),"Data listelendi");

    }

    @Override
    public DataResult<List<Product>> getAllByPage(int pageNo , int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<Product>>(this.productRepository.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.ASC,"id","productName");
        return new SuccessDataResult<List< Product >>(this.productRepository.findAll(sort), "Data listelendi.");
    }

}
