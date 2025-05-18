package com.backend.pangea.controllers.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.backend.pangea.annotations.TestInitializer;
import com.backend.pangea.entity.Services;
import com.backend.pangea.mock.MvcResultMock;
import com.backend.pangea.mock.ServiceMock;
import com.fasterxml.jackson.databind.ObjectMapper;

@TestInitializer
@AutoConfigureMockMvc
public class ServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Services service;

    @BeforeEach
    void setup() {
        service = ServiceMock.getService();
    }

    @Test
    void testSave() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/services/save");
        requestBuilder.content(objectMapper.writeValueAsString(service));
        requestBuilder.contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = MvcResultMock.getResponse(mockMvc, requestBuilder);

        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void testUpdate() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/services/update");
        requestBuilder.content(objectMapper.writeValueAsString(service));
        requestBuilder.contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = MvcResultMock.getResponse(mockMvc, requestBuilder);

        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void testDeleteById() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/services/delete/{id}", 1);

        MockHttpServletResponse response = MvcResultMock.getResponse(mockMvc, requestBuilder);

        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void testFindAll() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/services/find/all");

        MockHttpServletResponse response = MvcResultMock.getResponse(mockMvc, requestBuilder);

        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void testFindById() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/services/find/{id}", 1);

        MockHttpServletResponse response = MvcResultMock.getResponse(mockMvc, requestBuilder);

        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }
}
