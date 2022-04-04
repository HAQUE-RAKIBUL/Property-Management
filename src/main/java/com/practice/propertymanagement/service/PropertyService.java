package com.practice.propertymanagement.service;

import com.practice.propertymanagement.Entity.PropertyEntity;
import com.practice.propertymanagement.dto.PropertyModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {
     PropertyModel saveProperty(PropertyModel propertyModel);
     List<PropertyModel> findAll();
     PropertyModel updateProperty(PropertyModel propertyModel, Long propertyId);
     PropertyModel updatePropertyDescription(PropertyModel propertyModel, Long propertyId);
     void deletePropertyById(Long propertyId);

}
