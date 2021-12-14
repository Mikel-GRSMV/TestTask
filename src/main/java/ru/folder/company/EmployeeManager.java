package ru.folder.company;

import ru.folder.company.employees.DepartmentEnum;
import ru.folder.company.employees.Employee;


import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

//чтобы поле со списком сотрудников включить в сущность ITCompany:
@MappedSuperclass
public class EmployeeManager<T extends Employee<DepartmentEnum>> {
    //в компании будут сотрудники:
    @OneToMany(cascade = CascadeType.ALL)
    //сотрудники привязываются к id компании
    @JoinColumn(name = "company_id")
    private final List<T> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public List<T> getEmployees() {
        return employees;
    }
}
