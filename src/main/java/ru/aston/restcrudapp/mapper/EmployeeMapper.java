package ru.aston.restcrudapp.mapper;

import ru.aston.restcrudapp.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection (
                    "jdbc:postgresql://localhost:5432/restcrudapp",
                    "postgres",
                    "password");
        } catch(SQLException sqlException) {
            throw new RuntimeException("Cannot Connect the Database!", sqlException);
        } catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException(classNotFoundException);
        }
        return connection;
    }

    public static int save(Employee employee) {
        int status = 0;
        try {
            Connection connection = EmployeeMapper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement (
                    "insert into employees(name, department) values (?,?)");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getDepartment());
            status = preparedStatement.executeUpdate ();
            connection.close ();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return status;
    }

    public static int update(Employee employee) {
        int status = 0;
        try {
            Connection connection = EmployeeMapper.getConnection ();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update employees set name=?, department=? where id=?");
            preparedStatement.setString (1, employee.getName ());
            preparedStatement.setString (2, employee.getDepartment());
            preparedStatement.setInt (3, employee.getId ());
            status = preparedStatement.executeUpdate ();
            connection.close ();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection connection = EmployeeMapper.getConnection ();
            PreparedStatement preparedStatement =connection.prepareStatement (
                    "delete from employees where id=?");
            preparedStatement.setInt (1, id);
            status = preparedStatement.executeUpdate ();
            connection.close ();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return status;
    }

    public static Employee getEmployeeById(int id) {
        Employee employee = new Employee ();
        try {
            Connection connection = EmployeeMapper.getConnection ();
            PreparedStatement preparedStatement = connection.prepareStatement (
                    "select * from employees where id=?");
            preparedStatement.setInt (1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next ()) {
                employee.setId(resultSet.getInt (1));
                employee.setName(resultSet.getString (2));
                employee.setDepartment(resultSet.getString (3));
            } connection.close ();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return employee;
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<Employee>();
        try {
            Connection connection = EmployeeMapper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from employees");

            ResultSet resultSet = preparedStatement.executeQuery ();
            while (resultSet.next ()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));
                employee.setDepartment(resultSet.getString(3));
                list.add(employee);
            } connection.close ();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return list;
    }
}
