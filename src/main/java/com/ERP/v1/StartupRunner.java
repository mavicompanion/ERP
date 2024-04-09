package com.ERP.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ERP.v1.model.AppModule;
import com.ERP.v1.service.ModuleService;

@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired 
    ModuleService moduleService;
    @Override
    public void run(String... args) throws Exception {
        AppModule module1 = new AppModule( (long) 1, "Employee registration", "/admin/employeeRegistration", "ROLE_ADMIN");
        AppModule module2 = new AppModule( (long) 2, "Category registration", "/admin/categoryRegistration", "ROLE_ADMIN");
        moduleService.createModule(module1);
        moduleService.createModule(module2);
    }   
}