package com.practice.propertymanagement.controller;

import com.practice.propertymanagement.Entity.PropertyEntity;
import com.practice.propertymanagement.dto.PropertyModel;
import com.practice.propertymanagement.service.PropertyService;
import com.practice.propertymanagement.service.impl.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/v1/properties")
public class PropertyController {
    @Value("${pms.dummy:}")
    private String dummy;
    @Autowired
    PropertyService propertyService;
    //http://localhost:8080/app/v1/properties/hello
    /*@GetMapping("/hello")
    public String getProperty()
    {
        return "Hello world";
    }*/
    @PostMapping("/newProperty")
    public ResponseEntity<PropertyModel> saveProperty(@RequestBody PropertyModel propertyModel)
    {
        propertyModel = propertyService.saveProperty(propertyModel);
       // System.out.println(propertyModel);
        ResponseEntity<PropertyModel> responseEntity = new ResponseEntity<PropertyModel>(propertyModel, HttpStatus.CREATED);
        return responseEntity;
    }
    @GetMapping("/newProperty")
    public ResponseEntity<List<PropertyModel>> getAllProperties()
    {
        List<PropertyModel> propertyList = propertyService.findAll();
        System.out.println(dummy);
        System.out.println(dummy);
        ResponseEntity<List<PropertyModel>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);

        return responseEntity;
    }

    @PutMapping("/newProperty/{propertyId}")
    public ResponseEntity<PropertyModel> updateById(@RequestBody PropertyModel propertyModel, @PathVariable Long propertyId)
    {
        propertyModel = propertyService.updateProperty(propertyModel, propertyId);
        ResponseEntity<PropertyModel> responseEntity = new ResponseEntity<PropertyModel>(propertyModel, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/newProperty/property-description/{propertyId}")
    public ResponseEntity<PropertyModel> updatePropertyDescription(@RequestBody PropertyModel propertyModel, @PathVariable Long propertyId)
    {
        propertyModel = propertyService.updatePropertyDescription(propertyModel, propertyId);
        ResponseEntity<PropertyModel> responseEntity = new ResponseEntity<PropertyModel>(propertyModel, HttpStatus.OK);
        return responseEntity;

    }

    @DeleteMapping("/newProperty/{propertyId}")
    public ResponseEntity<Void> deletePropertyById(@PathVariable Long propertyId)
    {
        propertyService.deletePropertyById(propertyId);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }
}
