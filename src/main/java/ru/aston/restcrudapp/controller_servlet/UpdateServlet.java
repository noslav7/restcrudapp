package ru.aston.restcrudapp.controller_servlet;

import ru.aston.restcrudapp.entity.Employee;
import ru.aston.restcrudapp.mapper.EmployeeMapper;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateservlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h1>Update Employee</h1>");

        String stringId = request.getParameter("id");
        int id = Integer.parseInt(stringId);
        Employee employee = EmployeeMapper.getEmployeeById(id);

        out.print("<form action='updateservlet2' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"
                + employee.getId() + "'/></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"
                + employee.getName() + "'/></td></tr>");
        out.print("<tr><td>Department:</td><td><input type='text' name='department' value='"
                + employee.getDepartment() + "'/> </td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Update '/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }
}
