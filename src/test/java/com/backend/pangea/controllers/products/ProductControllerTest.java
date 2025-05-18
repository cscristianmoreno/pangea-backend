package com.backend.pangea.controllers.products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.backend.pangea.annotations.TestInitializer;
import com.backend.pangea.entity.Products;
import com.backend.pangea.entity.Services;
import com.backend.pangea.mock.MvcResultMock;
import com.backend.pangea.mock.ProductMock;
import com.backend.pangea.mock.ServiceMock;
import com.fasterxml.jackson.databind.ObjectMapper;

@TestInitializer
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Products product;

    @BeforeEach
    void setup() {
        product = ProductMock.getProduct();
    }

    @Test
    void testSave() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/products/save");
        requestBuilder.content(objectMapper.writeValueAsString(product));
        requestBuilder.contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = MvcResultMock.getResponse(mockMvc, requestBuilder);

        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void testUpdate() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/products/update");
        requestBuilder.content(objectMapper.writeValueAsString(product));
        requestBuilder.contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = MvcResultMock.getResponse(mockMvc, requestBuilder);

        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void testDeleteById() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/products/delete/{id}", 1);

        MockHttpServletResponse response = MvcResultMock.getResponse(mockMvc, requestBuilder);

        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void testFindAll() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/find/all");

        MockHttpServletResponse response = MvcResultMock.getResponse(mockMvc, requestBuilder);

        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void testFindById() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/find/{id}", 1);

        MockHttpServletResponse response = MvcResultMock.getResponse(mockMvc, requestBuilder);

        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }
}
