package com.backend.pangea.mock;

import com.backend.pangea.entity.Municipes;
import com.backend.pangea.entity.Services;

public abstract class ServiceMock {
    
    public static Services getService() {
        Municipes municipe = new Municipes();
        municipe.setName("Municipio");

        Services service = new Services();
        service.setName("Servicio ofrecido");
        service.setDescription("-");
        service.setMunicipe(municipe);

        return service;
    }   
}
