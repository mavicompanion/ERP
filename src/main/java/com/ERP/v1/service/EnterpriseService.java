package com.ERP.v1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ERP.v1.dto.EnterpriseDto;
import com.ERP.v1.model.Enterprise;
import com.ERP.v1.repository.EnterpriseRepository;

@Service
public class EnterpriseService {
    
    // Creating an Enterprise repository Bean;
    @Autowired
    EnterpriseRepository enterpriseRepository;

    // Service method for getting all enterprise names;
    public List<Enterprise> getAllEnterprises()
    {
        return enterpriseRepository.findAll();
    }

    // Service method for getting a particular enterprise with domain;
    public Enterprise getEnterprise(String domain)
    {
        List<Enterprise>  enterprises = this.getAllEnterprises();
        for(Enterprise enterprise : enterprises)
        {
            if (enterprise.getDomain().equals(domain))
            {
                return enterprise;
            }
        }
        return null;
    }

    // Service method to create a new enterprise;
    public void createEnterprise(EnterpriseDto enterpriseDto)
    {
        Enterprise enterprise = new Enterprise(
            enterpriseDto.getName(), 
            enterpriseDto.getDescription(), 
            enterpriseDto.getAddress(), 
            enterpriseDto.getDomain(),
            enterpriseDto.getContact()
            );
        enterpriseRepository.save(enterprise);
    }

    // Service method to delete an exisiting enterprise and its data;
    @SuppressWarnings("null")
    public void deleteEnterprise(String domain)
    {
        List<Enterprise>  enterprises = this.getAllEnterprises();
        for(Enterprise enterprise : enterprises)
        {
            if (enterprise.getDomain().equals(domain))
                enterpriseRepository.deleteById(enterprise.getId());
        }
    }

    // Service method to get all enterprise domain;
    public List<String> getAllDomains()
    {
        List<String> domains = new ArrayList<>();
        List<Enterprise>  enterprises = this.getAllEnterprises();
        for(Enterprise enterprise : enterprises)
        {
            domains.add(enterprise.getDomain());
        }
        return domains;
    }

}