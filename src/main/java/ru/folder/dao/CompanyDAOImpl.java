package ru.folder.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.folder.company.ITCompany;
import ru.folder.company.employees.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Primary
public class CompanyDAOImpl implements CompanyDAO {
    //SpringBoot за меня настроил все необходимые beans для работы с БД:
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Integer create(ITCompany company) {
        entityManager.persist(company);
        entityManager.flush();
        return company.getId();
    }

    @Override
    public ITCompany find(int id) {
        return entityManager.find(ITCompany.class, id);
    }

    @Override
    public void addDeveloper(Developer developer) {
        entityManager.persist(developer);
    }

    @Override
    public void addProjectManager(ProjectManager projectManager) {
        entityManager.persist(projectManager);
    }

    @Override
    public void addSystemEngineer(SystemEngineer systemEngineer) {
        entityManager.persist(systemEngineer);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(DepartmentEnum departmentEnum, int company_id) {
        List<Employee> employees = entityManager.createQuery(
                "select e from Employee e where e.departmentEnum = :department and e.company = :company", Employee.class)
                .setParameter("department", departmentEnum)
                .setParameter("company", find(company_id))
                .getResultList();

        return employees;
    }

    @Override
    public Employee<DepartmentEnum> getEmployeeByIndex(int employee_id) {
        Developer developer = entityManager.find(Developer.class, employee_id);
        return developer;
    }


}
