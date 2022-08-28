package com.example.springBoot.service;

import com.example.springBoot.entity.Department;
import com.example.springBoot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("Mumbai")
                        .departmentId(1L)
                        .departmentCode("IT-01")
                        .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);

    }
    @Test
    @DisplayName("Get Data based on valid department name")
    public void whenValidDepartment_thenDepartmentShouldFound(){
    String departmentName= "IT";
    Department found = departmentService.fetchDepartmentByName(departmentName);
    assertEquals(departmentName,found.getDepartmentName());
    }
}