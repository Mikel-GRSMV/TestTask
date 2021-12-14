package ru.folder.company.employees;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.folder.company.ITCompany;

import javax.persistence.*;

@Entity
@Table(name = "employees")
//стратегия наследования для сущностей БД:
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "departmentEnum")
    private T departmentEnum;
    @JsonIgnore
    //двусторонняя свзяь с компанией:
    @ManyToOne
    @JoinColumn(name = "company_id")
    private ITCompany company;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String phoneNumber, T departmentEnum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.departmentEnum = departmentEnum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public T getDepartmentEnum() {
        return departmentEnum;
    }

    public void setDepartmentEnum(T departmentEnum) {
        this.departmentEnum = departmentEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ITCompany getCompany() {
        return company;
    }

    public void setCompany(ITCompany company) {
        this.company = company;
    }

}
