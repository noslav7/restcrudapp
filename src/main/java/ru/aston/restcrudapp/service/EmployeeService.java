package ru.aston.restcrudapp.service;

import ru.aston.restcrudapp.entity.Employee;
import ru.aston.restcrudapp.repository.EmployeeRepository;

import java.util.List;

/*
Сделал все методы статическими только для того, чтобы ускорить написание кода сейчас.
Понимаю, что в постоянно поддерживаемых проектах, в которые вносятся дополнения и изменения
следует объявить переменную EmployeeRepository и использовать в методах ее, а все методы должны быть
нестатическими.
Аналогично в EmployeeRepository.
 */
public class EmployeeService {
    public static int save(Employee employee) {
        return EmployeeRepository.save(employee);
    }

    public static int update(Employee employee) {
        return EmployeeRepository.update(employee);
    }

    public static int delete(int id) {
        return EmployeeRepository.delete(id);
    }

    public static Employee getEmployeeById(int id) {
        return EmployeeRepository.getEmployeeById(id);
    }

    public static List<Employee> getAllEmployees() {
        return EmployeeRepository.getAllEmployees();
    }
}
