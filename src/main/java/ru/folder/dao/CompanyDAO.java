package ru.folder.dao;

import ru.folder.company.ITCompany;
import ru.folder.company.employees.*;

import java.util.List;

//интерфейс для работы с БД
public interface CompanyDAO {
    Integer create(ITCompany company);

    ITCompany find(int id);

    void addDeveloper(Developer developer);

    void addProjectManager(ProjectManager projectManager);

    void addSystemEngineer(SystemEngineer systemEngineer);

    List<Employee> getEmployeesByDepartment(DepartmentEnum departmentEnum, int company_id);

    Employee<DepartmentEnum> getEmployeeByIndex(int employee_id);


}
