package ru.folder.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.folder.company.ITCompany;
import ru.folder.company.employees.*;
import ru.folder.dao.CompanyDAO;

import java.util.List;

//В Service-class/слой вся бизнес логика.
@Service
public class ITCompanyServiceImpl implements ITCompanyService {
    @Autowired
    private CompanyDAO companyDAO;
//----------------------------------------------------Create Company--------------------------------------------------//

    @Override
    @Transactional
    public Integer createCompany(ITCompany company) {
        return companyDAO.create(company);
    }


//----------------------------------------------------Get All Workers-------------------------------------------------//

    @Override
    public ITCompany getITCompany(int id) {
        return companyDAO.find(id);
    }

    //--------------------------------------------------Add Employees-----------------------------------------------------//
    @Override
    @Transactional
    public void addDeveloper(Developer developer, int company_id) {
        developer.setCompany(getITCompany(company_id));
        companyDAO.addDeveloper(developer);
    }

    @Override
    @Transactional
    public void addProjectManager(ProjectManager projectManager, int company_id) {
        projectManager.setCompany(getITCompany(company_id));
        companyDAO.addProjectManager(projectManager);
    }

    @Override
    @Transactional
    public void addSystemEngineer(SystemEngineer systemEngineer, int company_id) {
        systemEngineer.setCompany(getITCompany(company_id));
        companyDAO.addSystemEngineer(systemEngineer);
    }


//---------------------------------------------Search Employees by index----------------------------------------------//

    @Override
    @Transactional
    public Employee<DepartmentEnum> getEmployeeByIndex(int id) {
        return null;
    }
//---------------------------------------------Search Employees by Department-----------------------------------------//

    @Override
    public List<Employee> getEmployeesByDepartment(DepartmentEnum departmentEnum, int company_id) {
        return companyDAO.getEmployeesByDepartment(departmentEnum, company_id);
    }

}
