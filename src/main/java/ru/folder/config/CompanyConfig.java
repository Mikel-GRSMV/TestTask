package ru.folder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.folder.company.ITCompany;

@Configuration
@ComponentScan("ru.folder.company")
public class CompanyConfig {
    @Bean
    @Primary
    public ITCompany getAccountingDepartment() {
        return new ITCompany("MyItCompany");
    }

}
