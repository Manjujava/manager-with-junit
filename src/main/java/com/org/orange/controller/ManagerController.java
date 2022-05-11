package com.org.orange.controller;

import com.org.orange.model.Manager;
import com.org.orange.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ManagerController {
    @Autowired
    ManagerService managerService;


    @PostMapping("/create")
    public void createManager(@RequestBody Manager manager) {
        managerService.createManager(manager);

    }

    @GetMapping("/getAll")
    public List<Manager> getAll() {
        List<Manager> list1 = managerService.getAll();
        return list1;

    }

    @PutMapping("/update")
    public String update(@RequestBody Manager manager) {
        String s = managerService.update(manager);
        return s;

    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable Integer id) {
        String s3 = managerService.deleteById(id);
        return s3;
    }

    @PutMapping("/updateAdressBasedOnId/{id}/{address}")
    public String updateAdressBasedOnId(@PathVariable Integer id, @PathVariable String address) {
        String s8 = managerService.updateAdressBasedOnId(id, address);
        return s8;

    }


}
