package com.example.springBoot.service;

import com.example.springBoot.entity.Department;
import com.example.springBoot.exception.DepartmentNotFoundException;
import com.example.springBoot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {

        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department= departmentRepository.findById(departmentId);
        if(!department.isPresent()){  // department not present
            throw new  DepartmentNotFoundException("Department not Available");
        }
        return department.get();
    }

    @Override
    public void deleteById(Long departmentId)throws DepartmentNotFoundException {
        Optional<Department> currDepartment= departmentRepository.findById(departmentId);
        // to handle the exception of specific id department not available.
        if(!currDepartment.isPresent()){
            throw new DepartmentNotFoundException("Department not available");
        }
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) throws DepartmentNotFoundException {
        Optional<Department> currDepartment= departmentRepository.findById(departmentId);
        // to handle the exception of specific id department not available.
        if(!currDepartment.isPresent()){
            throw new DepartmentNotFoundException("Department not available");
        }
        // to check the department we are passing is not null & blank.
        if(Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())){
            currDepartment.get().setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            currDepartment.get().setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            currDepartment.get().setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(currDepartment.get()) ;
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
