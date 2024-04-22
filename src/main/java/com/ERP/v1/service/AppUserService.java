package com.ERP.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ERP.v1.model.AppUser;
import com.ERP.v1.model.Employee;
import com.ERP.v1.repository.AppUserRepository;

@Service
public class AppUserService {
    @Autowired
    AppUserRepository appUserRepository;

    public void createUser(String email, String password, Employee employee, String role )
    {
        AppUser user = new AppUser(email, password, employee, role);
        appUserRepository.save(user);
    }

    public List<AppUser> getAllUsers()
    {
        return appUserRepository.findAll();
    }

    public AppUser getAppUser(String email)
    {
        List<AppUser> users = this.getAllUsers();
        for(AppUser user : users)
        {
            if (user.getEmail().equals(email))
            {
                return user;
            }
        }
        return null;
    }

    public AppUser getAppUserById(Long id)
    {
        return appUserRepository.findById(id).get();
    }

    public void deleteEmployeeById(Long id)
    {
        appUserRepository.deleteById(id);
    }

    public void editUser(AppUser user)
    {
        appUserRepository.save(user);
    }
}
