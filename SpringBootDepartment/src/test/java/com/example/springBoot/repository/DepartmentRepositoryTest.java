package com.example.springBoot.repository;

import com.example.springBoot.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager entityManager;
    @BeforeEach
    void setUp() {


        Department department =
                Department.builder()
                        .departmentName("Electrical Engineer")
                        .departmentCode("ME-01")
                        .departmentAddress("Delhi")
                        .build();


        entityManager.persist(department);
    }
    @Test
    @DisplayName("Get department name by id")
    public void whenFindById_thenReturnDepartment(){
        Department department = departmentRepository.findByDepartmentNameIgnoreCase("Electrical Engineer");
        assertEquals(department.getDepartmentName(),"Electrical Engineer");
    }

}