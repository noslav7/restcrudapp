package ru.aston.restcrudapp.controller_servlet;

import ru.aston.restcrudapp.entity.Employee;
import ru.aston.restcrudapp.mapper.EmployeeMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewservlet")
public class ViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType ("text/html");

        PrintWriter out = response.getWriter ();
        out.println ("<a href='index.html'>Add Employee</a>");
        out.println ("<h1>Employees List</h1>");
        out.print ("<table border='1' width='100%' ");
        out.print("<tr><th>Id</th><th>Name</th><th>Department</th><th>Update</th><th>Delete</th></tr>");

        List<Employee> list = EmployeeMapper.getAllEmployees();
        for (Employee employee : list) {
            out.print ("<tr><td>" + employee.getId() + "</td><td>" + employee.getName() +
                    "</td><td>" + employee.getDepartment() +
                    "</td><td><a href='updateservlet?id=" + employee.getId() +
                    "'>update</a></td>  <td><a href='deleteservlet?id=" +
                    employee.getId() + "'>delete</a></td></tr>");
        }
        out.print ("</table>");
        out.close ();
    }
}
