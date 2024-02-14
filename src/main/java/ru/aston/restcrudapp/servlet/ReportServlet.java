package ru.aston.restcrudapp.servlet;

import ru.aston.restcrudapp.entity.Employee;
import ru.aston.restcrudapp.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet ("/reportservlet")
public class ReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String department = request.getParameter("department");
        Employee employee = new Employee();
        employee.setName(name);
        employee.setDepartment(department);
        int status = EmployeeService.save(employee);

        PrintWriter out = response.getWriter();
        if (status > 0) {
            out.print("<p>Record saved successfully!</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        } else {
            out.println("Unable to save record!");
        }
        out.close();
    }
}