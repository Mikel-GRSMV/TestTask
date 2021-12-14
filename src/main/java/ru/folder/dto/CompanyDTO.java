package ru.folder.dto;

import lombok.Data;
import org.springframework.util.CollectionUtils;
import ru.folder.company.ITCompany;
import ru.folder.company.employees.DepartmentEnum;
import ru.folder.company.employees.Employee;

import java.util.List;
import java.util.stream.Collectors;

@Data
//DTO - Data Transfer Object - та сущность, которая будет отдаваться клиенту.
public class CompanyDTO {
    private String name;
    private List<EmployeeDTO> employees;

    //получает экземпляр класса DepartmentDTO из бизнес сущности ITCompany.
    public static CompanyDTO from(ITCompany company) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setName(company.getCompanyName());

        List<EmployeeDTO> employeeDTOList = company.getEmployees().stream()
                .map(EmployeeDTO::from)
                .collect(Collectors.toList());
        companyDTO.setEmployees(employeeDTOList);
        //возвращаю экземпляр класса DepartmentDTO:
        return companyDTO;
    }

    //я получаю сущность ITCompany
    public ITCompany toCompany() {
        ITCompany company = new ITCompany(this.name);

        if (!CollectionUtils.isEmpty(this.employees)) {
            List<Employee<DepartmentEnum>> employees = this.employees.stream()
                    .map(EmployeeDTO::toEmployee)
                    .peek(e -> e.setCompany(company))
                    .collect(Collectors.toList());
            company.getEmployees().addAll(employees);
        }
        return company;
    }
}
