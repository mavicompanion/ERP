package com.ERP.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ERP.v1.model.AppModule;
import com.ERP.v1.repository.ModuleRepository;

@Service
public class ModuleService {
    @Autowired
    ModuleRepository moduleRepository;

    public List<AppModule> getAllModules()
    {
        return moduleRepository.findAll();
    }

    public void createModule(AppModule module)
    {
        moduleRepository.save(module);
    }
}
