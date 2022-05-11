package com.org.orange.service;

import com.org.orange.model.Manager;

import java.util.List;

public interface ManagerService {
    public void createManager( Manager manager);
    public List<Manager> getAll();
    public String update( Manager manager);
    public String deleteById( Integer id);
    public String updateAdressBasedOnId(Integer id, String address );



    }
