package ru.aston.restcrudapp.controller_servlet;

import ru.aston.restcrudapp.entity.Employee;
import ru.aston.restcrudapp.mapper.EmployeeMapper;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/updateservlet2")
public class UpdateServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType ("text/html");

        String sid = request.getParameter ("id");
        int id = Integer.parseInt (sid);
        String name = request.getParameter ("name");
        String department = request.getParameter ("department");
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setDepartment(department);
        int status = EmployeeMapper.update (employee);

        PrintWriter out = response.getWriter ();
        if (status > 0) {
            out.println ("Record updated successfully...");
            response.sendRedirect("viewservlet");
        } else {
            out.println ("Sorry! unable to update record");
        }
        out.close ();
    }
}
