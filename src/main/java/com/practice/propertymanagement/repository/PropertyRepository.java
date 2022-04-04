package com.practice.propertymanagement.repository;

import com.practice.propertymanagement.Entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
}
