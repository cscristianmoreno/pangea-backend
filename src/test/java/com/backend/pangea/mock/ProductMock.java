package com.backend.pangea.mock;

import com.backend.pangea.entity.Producers;
import com.backend.pangea.entity.Products;
import com.backend.pangea.entity.Users;

public abstract class ProductMock {
    
    public static Products getProduct() {
        Users user = UserMock.getUser();

        Producers producer = new Producers();
        producer.setUser(user);
        Products product = new Products();

        product.setName("asd");
        product.setProducer(producer);
        // producer.set

        return product;
    }
}
