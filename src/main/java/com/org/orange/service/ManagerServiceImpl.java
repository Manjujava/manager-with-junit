package com.org.orange.service;

import com.org.orange.model.Manager;
import com.org.orange.repository.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerRepo managerRepo;


    @Override
    public void createManager(Manager manager) {
        managerRepo.save(manager);

    }

    @Override
    public List<Manager> getAll() {
        List<Manager> list   =managerRepo.findAll();
        return list;
    }

    @Override
    public String update(Manager manager) {
      managerRepo.save(manager);
     return "update successfully";

    }

    @Override
    public String deleteById(Integer id) {
        managerRepo.deleteById(id);
        return "delete successfully";
    }

    @Override
    public String updateAdressBasedOnId(Integer id, String address) {
          Optional<Manager> optional   = managerRepo.findById(id);
        Manager manager   = optional.get();
        manager.setAddress(address);
        managerRepo.save(manager);

        return "update address based on id";

    }



}

