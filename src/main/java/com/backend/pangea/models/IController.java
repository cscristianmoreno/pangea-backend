package com.backend.pangea.models;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.backend.pangea.dto.HttpResponseEntity;

public interface IController<T> {
    @PostMapping("/save")
    ResponseEntity<HttpResponseEntity<T>> save(@RequestBody T entity);

    @PutMapping("/update")
    ResponseEntity<HttpResponseEntity<T>> update(@RequestBody T entity);

    @GetMapping("/find/{id}")
    ResponseEntity<HttpResponseEntity<Optional<T>>> findById(@PathVariable int id);

    @GetMapping("/find/all")
    ResponseEntity<HttpResponseEntity<List<T>>> findAll();
    
    @DeleteMapping("/delete/{id}")
    ResponseEntity<HttpResponseEntity<Void>> deleteById(@PathVariable int id);
}
