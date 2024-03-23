package org.example.springwebmvc.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.springwebmvc.dto.ProductCreateRequest;
import org.example.springwebmvc.dto.ProductEditRequest;
import org.example.springwebmvc.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;


    @PutMapping("/{uuid}")
    void editProductByUuid(@PathVariable String uuid,
                           @RequestBody ProductEditRequest request) {
        productService.editProductByUuid(uuid, request);
    }
    @DeleteMapping("/{uuid}")
    void deleteProductByUuid(@PathVariable String uuid){
        productService.deleteProductByUuid(uuid);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createNewProduct(@Valid @RequestBody ProductCreateRequest request){
        System.out.println("REQUEST:"+request);
        productService.createNewProduct(request);
    }

    @GetMapping()
    ResponseEntity<Map<String,Object>> findProducts(@RequestParam(required = false, defaultValue = "") String name,

                                                    @RequestParam(required = false, defaultValue = "true") Boolean status) {
        Map<String ,Object> data = Map.of(
                "message", "Products have been found",
                "data", productService.findProducts(name, status));

        return ResponseEntity.accepted().body(data);

    }
    @GetMapping("/{id}")
    Map<String, Object> findProductById(@PathVariable Integer id) {
        return Map.of(
                "message", "Product has been found",
                "data", productService.findProductById(id)
        );
    }

    @GetMapping("/uuid/{uuid}")
    Map<String, Object> findProductByUuid(@PathVariable String uuid) {
        return Map.of(
                "message", "Product has been found",
                "data", productService.findProductByUuid(uuid)
        );
    }

}
