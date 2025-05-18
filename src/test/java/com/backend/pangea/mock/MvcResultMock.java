package com.backend.pangea.mock;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

public abstract class MvcResultMock {
    
    public static MockHttpServletResponse getResponse(final MockMvc mockMvc, final MockHttpServletRequestBuilder requestBuilder) throws Exception {
        ResultActions result = mockMvc.perform(requestBuilder);
        MvcResult mvcResult = result.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        return response;
    }
}
