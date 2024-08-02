package com.pagingsorting.services;

import com.pagingsorting.entity.Product;
import com.pagingsorting.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService
{

    @Autowired
    private ProductRepository productRepository;

    //get all products
    public Page<Product> getProducts(Pageable pageable)
    {
        return productRepository.findAll(pageable);
    }
    
    //post 
    public Product createProduct(Product product)
    {
        return productRepository.save(product);
    }

    //put
    public Product updateProduct(Long id, Product product) 
    {
        if (productRepository.existsById(id))
        {
            product.setId(id); 
            return productRepository.save(product);
        }
        return null;
    } 
   //delete
    public void deleteProduct(Long id) 
    {
        productRepository.deleteById(id);
    }
}
