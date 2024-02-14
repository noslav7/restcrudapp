package ru.aston.restcrudapp.servlet;

import ru.aston.restcrudapp.service.EmployeeService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteservlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");

        String employeeId = request.getParameter("id");
        int id = Integer.parseInt(employeeId);
        EmployeeService.delete(id);
        int status = EmployeeService.delete(id);

        PrintWriter out = response.getWriter();
        if (status > 0) {
            out.print("<p>Record deleted successfully!</p>");
            response.sendRedirect("viewservlet");
        } else {
            out.println("Unable to delete record!");
        }

        response.sendRedirect("viewservlet");
    }
}
