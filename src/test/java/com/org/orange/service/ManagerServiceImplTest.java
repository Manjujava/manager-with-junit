package com.org.orange.service;

import com.org.orange.model.Manager;
import com.org.orange.repository.ManagerRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ManagerServiceImplTest {
    @InjectMocks
   private ManagerServiceImpl managerServiceImpl;
    @Mock
   private ManagerRepo managerRepo;

    @Test
    void createManager() {
        Manager manager=new Manager();
        manager.setAddress("blr");
        manager.setId(100);
        manager.setName("manju");
        managerServiceImpl.createManager(manager);
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
        Mockito.when(managerRepo.findAll()).thenReturn(list);
        List<Manager> list1  =managerServiceImpl.getAll();
        Assertions.assertEquals(list,list1);



    }

    @Test
    void update() {
        Manager manager=new Manager();
        manager.setAddress("blr");
        manager.setId(100);
        manager.setName("manju");
        String s="update successfully";
        managerServiceImpl.update(manager);
        Mockito.verify(managerRepo,Mockito.times(1)).save(manager);


    }

    @Test
    void deleteById() {
        int id=100;
        String s1="delete successfully";
        String   s2 =managerServiceImpl.deleteById(id);
        Assertions.assertEquals(s1,s2);
        Mockito.verify(managerRepo,Mockito.times(1)).deleteById(id);

    }

    @Test
     void updateAddressBasedOnId() {
        int id=100;
        String s3="blr";
        String s4="update address based on id";
        Manager manager=new Manager();
        manager.setAddress("blr");
        manager.setId(100);
        manager.setName("manju");
        Optional<Manager> optional=Optional.ofNullable(manager);
        Mockito.when(managerRepo.findById(id)).thenReturn(optional);
        String s5 = managerServiceImpl.updateAdressBasedOnId(id,s3);
        Assertions.assertEquals(s4,s5);




    }
}