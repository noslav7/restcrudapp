package ru.aston.restcrudapp.servlet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class AddServletTest {
    private AddServlet addServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private

    @BeforeEach
    void setUp() {
        addServlet = new AddServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    void doPost() throws ServletException, IOException {
        request.setAttribute("id", "10");

        addServlet.doPost(request, response);

        //Assertions.assertEquals("10", response.getContentAsString());
    }
}