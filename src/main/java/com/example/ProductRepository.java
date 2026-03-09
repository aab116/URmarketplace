//____________________________________________________________________________________________
//                              File Description: 
//          Interface for handling product data storage and retrieval operations
//____________________________________________________________________________________________

package com.example;


import java.util.List;
import java.util.Optional;


public interface ProductRepository
{
    Product save(Product product);
    Optional<Product> findById(int id);
    List<Product> findAll();
    List<Product> findBySellerId(int sellerId);
    void deleteById(int id);
}
