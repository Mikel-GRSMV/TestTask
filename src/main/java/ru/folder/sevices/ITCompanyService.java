package ru.folder.sevices;

import ru.folder.company.ITCompany;
import ru.folder.company.employees.*;

import java.util.List;

public interface ITCompanyService {
    Integer createCompany(ITCompany company);

    ITCompany getITCompany(int id);

    void addDeveloper(Developer developer, int company_id);

    void addProjectManager(ProjectManager projectManager, int company_id);

    void addSystemEngineer(SystemEngineer systemEngineer, int company_id);

    Employee<DepartmentEnum> getEmployeeByIndex(int id);

    List<Employee> getEmployeesByDepartment(DepartmentEnum departmentEnum, int company_id);

}
