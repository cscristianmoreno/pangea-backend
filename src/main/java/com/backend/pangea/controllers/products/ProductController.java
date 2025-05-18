package com.backend.pangea.controllers.products;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.pangea.dto.HttpResponseEntity;
import com.backend.pangea.entity.Products;
import com.backend.pangea.models.controllers.products.IProductController;
import com.backend.pangea.services.ProductRepositoryService;
import com.backend.pangea.utils.HttpResponseEntityUtil;

@Controller
@ResponseBody
@RequestMapping("/products")
public class ProductController implements IProductController {

    private final ProductRepositoryService productRepositoryService;

    public ProductController(final ProductRepositoryService productRepositoryService) {
        this.productRepositoryService = productRepositoryService;
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Products>> save(Products entity) {
        Products result = productRepositoryService.save(entity);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Products>> update(Products entity) {
        Products result = productRepositoryService.update(entity);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Optional<Products>>> findById(int id) {
        Optional<Products> result = productRepositoryService.findById(id);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<List<Products>>> findAll() {
        List<Products> result = productRepositoryService.findAll();
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Void>> deleteById(int id) {
        productRepositoryService.deleteById(id);
        return HttpResponseEntityUtil.ok(null);
    }
    
}
