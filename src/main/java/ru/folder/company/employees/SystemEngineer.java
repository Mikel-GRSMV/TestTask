package ru.folder.company.employees;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "systemEngineersDepartment")
public class SystemEngineer extends Employee<DepartmentEnum> {
    public SystemEngineer() {
    }

    public SystemEngineer(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName, phoneNumber, DepartmentEnum.SE);
    }
}
