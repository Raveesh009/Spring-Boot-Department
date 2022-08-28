package com.example.springBoot.repository;

import com.example.springBoot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

   public Department findByDepartmentNameIgnoreCase(String departmentName);
}
