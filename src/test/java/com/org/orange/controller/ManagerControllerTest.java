package com.org.orange.controller;

import com.org.orange.model.Manager;
import com.org.orange.service.ManagerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ManagerControllerTest {
    @InjectMocks
    ManagerController managerController;
    @Mock
    ManagerService managerService;
    @Test
    void createManager() {
        Manager manager=new Manager();
        manager.setAddress("blr");
        manager.setId(100);
        manager.setName("manju");
        managerController.createManager(manager);
    }

    @Test
    void getAll() {
        List<Manager> list=new ArrayList<>();
        Manager manager=new Manager();
        manager.setAddress("blr");
        manager.setId(100);
        manager.setName("manju");
        list.add(manager);
        Manager manager1=new Manager();
        manager1.setAddress("blr");
        manager1.setId(102);
        manager1.setName("manju");
        list.add(manager1);
        Mockito.when(managerService.getAll()).thenReturn(list);
        List<Manager> list1  =managerController.getAll();
        Assertions.assertEquals(list,list1);
    }

    @Test
    void update() {
        Manager manager=new Manager();
        manager.setAddress("blr");
        manager.setId(100);
        manager.setName("manju");
        String s="update successfully";
        managerController.update(manager);


    }

    @Test
    void deleteById() {

    }

    @Test
    void updateAdressBasedOnId() {
    }
}