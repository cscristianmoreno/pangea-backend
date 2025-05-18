package com.backend.pangea.controllers.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.assertj.MockMvcTester.MockMvcRequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.backend.pangea.annotations.TestInitializer;
import com.backend.pangea.entity.Administrators;
import com.backend.pangea.entity.Consumers;
import com.backend.pangea.entity.Producers;
import com.backend.pangea.entity.Products;
import com.backend.pangea.entity.Users;
import com.backend.pangea.mock.MvcResultMock;
import com.backend.pangea.mock.UserMock;
import com.fasterxml.jackson.databind.ObjectMapper;

@TestInitializer
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Users user;

    @BeforeEach
    void setup() {
        user = UserMock.getUser();

        Producers producer = new Producers();
        Products product = new Products();
        Consumers consumer = new Consumers();
        // producer.setProduct(List.of(product));

        user.setAdministrator(new Administrators());
        user.setProducer(producer);
        user.setConsumer(consumer);
    }

    @Test
    void testSave() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/save");
        requestBuilder.content(objectMapper.writeValueAsString(user));
        requestBuilder.contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = MvcResultMock.getResponse(mockMvc, requestBuilder);

        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void testUpdate() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/users/update");
        requestBuilder.content(objectMapper.writeValueAsString(user));
        requestBuilder.contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = MvcResultMock.getResponse(mockMvc, requestBuilder);

        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void testDeleteById() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/delete/{id}", 1);

        MockHttpServletResponse response = MvcResultMock.getResponse(mockMvc, requestBuilder);

        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void testFindAll() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/find/all");

        MockHttpServletResponse response = MvcResultMock.getResponse(mockMvc, requestBuilder);

        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void testFindById() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/find/{id}", 1);

        MockHttpServletResponse response = MvcResultMock.getResponse(mockMvc, requestBuilder);

        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }
}
