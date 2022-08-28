package com.example.springBoot.controller;

import com.example.springBoot.entity.Department;
import com.example.springBoot.exception.DepartmentNotFoundException;
import com.example.springBoot.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    // logging help us to debug the code and to tell when the particular method is executed.

   // for the documentation
    @Operation(summary = "To save the Department in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Department is stored in Database successfully",
            content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
            description = "Not Available",
            content = {@Content})
    })
    @PostMapping("/departments")
    public Department saveDepartments(@Valid @RequestBody Department department){
        LOGGER.info("Inside the saveDepartment method.");
        return departmentService.saveDepartment(department);
    }


    @Operation(summary = "To fetch all department list from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Department is fetched from Database successfully",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = {@Content})
    })
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside the fetchDepartmentList method");
        return departmentService.fetchDepartmentList();
    }

    @Operation(summary = "To fetch the department from the given id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Department is fetched successfully",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Exception is handled by Exception handler.",
                    content = {@Content})
    })
    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }

    @Operation(summary = "To delete specific given id department from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Department is deleted from Database successfully",
                    content = {@Content(mediaType = "application/json")})
    })
    @DeleteMapping("/departments/{id}")
    public String deleteById(@PathVariable("id") Long departmentId)throws DepartmentNotFoundException{
        departmentService.deleteById(departmentId);
        return "Department deleted Successfully";
    }

     @Operation(summary = "To update specific id department in the database.")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "200",
                     description = "Department is updated successfully",
                     content = {@Content(mediaType = "application/json")})
     })
    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId ,
                                           @RequestBody Department department)throws DepartmentNotFoundException{
        return departmentService.updateDepartmentById(departmentId,department);

    }

    @Operation(summary = "To get the department whose specific name is given")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = " Fetched the Department from the given name successfully",
                    content = {@Content(mediaType = "application/json")})
    })
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
