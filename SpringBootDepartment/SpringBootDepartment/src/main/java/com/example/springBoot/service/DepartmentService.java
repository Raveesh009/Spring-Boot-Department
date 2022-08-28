package com.example.springBoot.service;

import com.example.springBoot.entity.Department;
import com.example.springBoot.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteById(Long departmentId)throws DepartmentNotFoundException;

    Department updateDepartmentById(Long departmentId, Department department) throws DepartmentNotFoundException;


    Department fetchDepartmentByName(String departmentName);
}
