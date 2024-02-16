package ru.aston.restcrudapp.servlet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

class AddServletTest extends Mockito {

    @Test
    void doPost() throws IOException {
        /*HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("name")).thenReturn("Krotov Leonid");
        when(request.getParameter("department")).thenReturn("Marketing");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new AddServlet().doPost(request, response);

        verify(request, atLeast(1)).getParameter("name"); // only if you want to verify username was called...
        writer.flush(); // it may not have been flushed yet...
        Assertions.assertTrue(stringWriter.toString().contains("My expected string"));*/
    }
}