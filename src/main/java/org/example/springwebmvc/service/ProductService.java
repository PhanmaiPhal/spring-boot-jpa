package org.example.springwebmvc.service;

import org.example.springwebmvc.dto.ProductCreateRequest;
import org.example.springwebmvc.dto.ProductResponse;
import org.example.springwebmvc.dto.ProductEditRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    void createNewProduct(ProductCreateRequest request);
    List<ProductResponse> findProducts(String name, Boolean status);
    void editProductByUuid(String uuid, ProductEditRequest request);
    void deleteProductByUuid(String uuid);
    ProductResponse findProductById(Integer id);

    ProductResponse findProductByUuid(String uuid);


}
