package ru.folder.company;

import ru.folder.company.employees.DepartmentEnum;
import ru.folder.company.employees.Employee;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class ITCompany extends EmployeeManager<Employee<DepartmentEnum>> {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "companyName")
    private String companyName;

    public ITCompany() {
    }

    public ITCompany(String companyName) {
        super();
        this.companyName = companyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
