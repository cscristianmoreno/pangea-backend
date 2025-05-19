package com.backend.pangea.mock;

import com.backend.pangea.entity.Municipes;

public abstract class MunicipeMock {
    
    public static Municipes getMunicipe() {
        Municipes municipe = new Municipes();
        municipe.setName("Municipio de San Lorenzo");

        return municipe;
    }
}
