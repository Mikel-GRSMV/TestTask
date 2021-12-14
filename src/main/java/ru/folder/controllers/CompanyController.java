package ru.folder.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.folder.company.employees.*;
import ru.folder.dto.CompanyDTO;
import ru.folder.dto.EmployeeDTO;
import ru.folder.sevices.ITCompanyService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
//view по умолчанию будет JSON
@RestController
//изначальный URL
@RequestMapping("/myCompany")
public class CompanyController {
    @Autowired
    private ITCompanyService service;

    //----------------------------------------------------Create Company--------------------------------------------------//
    @PostMapping
    public Integer createCompany(@RequestBody CompanyDTO companyDTO) {
        return service.createCompany(companyDTO.toCompany());
    }

//----------------------------------------------------Get All Workers-------------------------------------------------//

    //обработка Get-request по URL = /myCompany.
    @GetMapping("/{id}")
    public CompanyDTO getCompany(@PathVariable int id) {
        return CompanyDTO.from(service.getITCompany(id));
    }

//--------------------------------------------------Add Employees-----------------------------------------------------//

    //тело запроса по этому URL, десериализуем из JSON в объект Developer.
    //{id} - добавляем разработчика в указонный id компании.
    @PostMapping("/{id}/employees/add/developer")
    public ResponseEntity addEmployee(@RequestBody Developer developer, @PathVariable(name = "id") int company_id) {
        log.info("add employee: developer");
        service.addDeveloper(developer, company_id);
        return ResponseEntity.ok().build();
    }

    //тело запроса по этому URL, десериализуем из JSON в объект ProjectManager.
    @PostMapping("/{id}/employees/add/projectManager")
    public ResponseEntity addEmployee(@RequestBody ProjectManager projectManager, @PathVariable(name = "id") int company_id) {
        log.info("add employee: projectManager");
        service.addProjectManager(projectManager, company_id);
        return ResponseEntity.ok().build();
    }

    //тело запроса по этому URL, десериализуем из JSON в объект SystemEngineer.
    @PostMapping("/{id}/employees/add/systemEngineer")
    public ResponseEntity addEmployee(@RequestBody SystemEngineer systemEngineer, @PathVariable(name = "id") int company_id) {
        log.info("add employee: systemEngineer");
        service.addSystemEngineer(systemEngineer, company_id);
        return ResponseEntity.ok().build();
    }

//---------------------------------------Search and remove Employees by index-----------------------------------------//

//    {}-параметр, который может менять пользователь на своей стороне,то есть вместо {index} указываем номер индекса.
//    @GetMapping("/search/employee/by/{index}")
//    public ResponseEntity<Employee<DepartmentEnum>> getEmployeeByIndex(@PathVariable int index) {
//        log.info("get employee by index: " + index);
//        try {
//            //нашли->отдаем ответ со статусом ок и телом сообщения данного employee:
//            return ResponseEntity.ok(service.getEmployeeByIndex(index));
//        } catch (IndexOutOfBoundsException e) {
//            //не нашли->отдаем ответ не найден:
//            return ResponseEntity.notFound().build();
//        }
//    }


//---------------------------------------------Search Employees by Department-----------------------------------------//

    //поиск по параметру запроса: ?department=DEV
    //{id} - поиск сотрудника по указанному id компании.
    @GetMapping("/{id}/search/employees/by")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByDepartment(
            @RequestParam(name = "department") DepartmentEnum departmentEnum,
            @PathVariable(name = "id") int company_id) {
        log.info("get employee by department: " + departmentEnum);

        List<EmployeeDTO> result = service.getEmployeesByDepartment(departmentEnum, company_id)
                .stream()
                .map(EmployeeDTO::from)
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

}
