package ru.aston.restcrudapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addservlet")
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        processRequest(request, response);

        try {
            String stringId = request.getParameter("id");
            int id = Integer.parseInt(stringId);
            String name = request.getParameter("name");
            String department = request.getParameter("department");

            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/restcrudapp",
                    "postgres",
                    "password");

            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into employees values (" +
                    "" + id + ",'" + name + "', '" + department + "')");

            PrintWriter out = response.getWriter();
            out.println("<h1>Record Inserted Successfully</h1>");
            String sql = "select * from employees";
            ResultSet resultSet = statement.executeQuery(sql);

            out.println("<form action = 'viewservlet' method='post'>");
            out.print("<tr><a href ='viewservlet'>View Employee</a></td></tr>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException sqlException) {
            throw new RuntimeException("Can't connect the database!", sqlException);
        } catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException(classNotFoundException);
        }
    }
}
