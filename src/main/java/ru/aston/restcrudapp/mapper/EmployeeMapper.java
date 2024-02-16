package ru.aston.restcrudapp.mapper;

import org.modelmapper.ModelMapper;
import ru.aston.restcrudapp.dto.EmployeeDTO;
import ru.aston.restcrudapp.entity.Employee;

public class EmployeeMapper {
    public Employee convertToEmployee(EmployeeDTO employeeDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(employeeDTO, Employee.class);
    }
}
