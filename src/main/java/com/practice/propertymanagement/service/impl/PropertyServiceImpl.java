package com.practice.propertymanagement.service.impl;

import com.practice.propertymanagement.Converter.PropertyConverter;
import com.practice.propertymanagement.Entity.PropertyEntity;
import com.practice.propertymanagement.Entity.UserEntity;
import com.practice.propertymanagement.dto.PropertyModel;
import com.practice.propertymanagement.exception.BusinessException;
import com.practice.propertymanagement.exception.ErrorModel;
import com.practice.propertymanagement.repository.PropertyRepository;
import com.practice.propertymanagement.repository.UserRepository;
import com.practice.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Autowired
    private UserRepository userRepository;

    @Override
    public PropertyModel saveProperty(PropertyModel propertyModel) {
        /*PropertyEntity pe = propertyConverter.dtoToEntity(propertyModel);

        pe = propertyRepository.save(pe);
        propertyModel = propertyConverter.entityToDto(pe);*/

        Optional<UserEntity> optUe = userRepository.findById(propertyModel.getUserId());
        if(optUe.isPresent()) {
            PropertyEntity pe = propertyConverter.dtoToEntity(propertyModel);
            pe.setUserEntity(optUe.get());
            pe = propertyRepository.save(pe);

            propertyModel = propertyConverter.entityToDto(pe);
        }else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("USER_ID_NOT_EXIST");
            errorModel.setMessage("User does not exist");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        return propertyModel;
    }

    @Override
    public List<PropertyModel> findAll() {

        List<PropertyEntity> listOfProperty = (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyModel> propList = new ArrayList<>();

        for(PropertyEntity pe: listOfProperty)
        {
            PropertyModel dto = propertyConverter.entityToDto(pe);
            propList.add(dto);
        }
        return propList;
    }

    @Override
    public PropertyModel updateProperty(PropertyModel propertyModel, Long propertyId) {

        Optional<PropertyEntity> optionalEn = propertyRepository.findById(propertyId);
        PropertyModel dto = null;
        if(optionalEn.isPresent())
        {
            PropertyEntity pe = optionalEn.get();
            pe.setTitle(propertyModel.getTitle());
            pe.setDescription(propertyModel.getDescription());
            pe.setOwnerAddress(propertyModel.getOwnerAddress());
            pe.setPrice(propertyModel.getPrice());
            dto = propertyConverter.entityToDto(pe);
            propertyRepository.save(pe);

        }
        return dto;
    }

    @Override
    public PropertyModel updatePropertyDescription(PropertyModel propertyModel, Long propertyId) {
        Optional<PropertyEntity> optionalEn = propertyRepository.findById(propertyId);
        PropertyModel dto = null;
        if(optionalEn.isPresent())
        {
            PropertyEntity pe = optionalEn.get();
            pe.setDescription(propertyModel.getDescription());
            dto = propertyConverter.entityToDto(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deletePropertyById(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }


}
