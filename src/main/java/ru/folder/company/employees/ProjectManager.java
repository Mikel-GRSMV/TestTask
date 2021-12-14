package ru.folder.company.employees;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "projectManagersDepartment")
public class ProjectManager extends Employee<DepartmentEnum> {
    public ProjectManager() {
    }

    public ProjectManager(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName, phoneNumber, DepartmentEnum.PM);
    }
}
