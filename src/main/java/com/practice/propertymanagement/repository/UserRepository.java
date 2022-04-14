package com.practice.propertymanagement.repository;

import com.practice.propertymanagement.Entity.PropertyEntity;
import com.practice.propertymanagement.Entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    @Query("SELECT t FROM UserEntity t WHERE t.ownerMail=?1 AND t.password=?2")
    Optional<UserEntity> findbyOwnerMailAndPassword(String mail, String password);

    @Query("SELECT t FROM UserEntity t WHERE t.ownerMail=?1")
    Optional<UserEntity> findbyOwnerMail(String mail);

}
