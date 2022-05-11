package com.org.orange.repository;

import com.org.orange.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ManagerRepo extends JpaRepository<Manager,Integer> {


}
