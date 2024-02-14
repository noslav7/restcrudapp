package ru.aston.restcrudapp.servlet;

import ru.aston.restcrudapp.entity.Employee;
import ru.aston.restcrudapp.service.EmployeeService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/updatebuttonservlet")
public class UpdateButtonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setDepartment(department);
        int status = EmployeeService.update(employee);

        PrintWriter out = response.getWriter();
        if (status > 0) {
            out.println("Record updated successfully...");
            response.sendRedirect("viewservlet");
        } else {
            out.println("Unable to update record");
        }
        out.close ();
    }
}
