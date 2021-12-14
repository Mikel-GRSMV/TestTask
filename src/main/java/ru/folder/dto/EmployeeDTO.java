package ru.folder.dto;

import lombok.Data;
import ru.folder.company.employees.DepartmentEnum;
import ru.folder.company.employees.Employee;

@Data
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private DepartmentEnum departmentEnum;

    public static EmployeeDTO from(Employee<DepartmentEnum> employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setPhoneNumber(employee.getPhoneNumber());
        dto.setDepartmentEnum(employee.getDepartmentEnum());
        return dto;
    }

    //превращает из DTO в нашу сущность
    public Employee<DepartmentEnum> toEmployee() {
        Employee<DepartmentEnum> employee = new Employee<>();
        employee.setId(this.id);
        employee.setFirstName(this.firstName);
        employee.setLastName(this.lastName);
        employee.setPhoneNumber(this.phoneNumber);
        employee.setDepartmentEnum(this.departmentEnum);
        return employee;
    }

}
