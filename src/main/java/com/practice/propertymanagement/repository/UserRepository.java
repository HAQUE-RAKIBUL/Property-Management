package com.practice.propertymanagement.repository;

import com.practice.propertymanagement.Entity.PropertyEntity;
import com.practice.propertymanagement.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
