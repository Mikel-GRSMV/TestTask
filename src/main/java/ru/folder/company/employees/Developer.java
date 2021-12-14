package ru.folder.company.employees;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "developersDepartment")
public class Developer extends Employee<DepartmentEnum> {
    public Developer() {
    }

    public Developer(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName, phoneNumber, DepartmentEnum.DEV);
    }
}
