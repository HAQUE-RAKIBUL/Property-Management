package com.practice.propertymanagement.Converter;

import com.practice.propertymanagement.Entity.PropertyEntity;
import com.practice.propertymanagement.dto.PropertyModel;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity dtoToEntity(PropertyModel propertyModel)
    {
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyModel.getTitle());
        pe.setDescription(propertyModel.getDescription());
        pe.setOwnerName(propertyModel.getOwnerName());
        pe.setOwnerAddress(propertyModel.getOwnerAddress());
        pe.setOwnerMail(propertyModel.getOwnerMail());
        pe.setPrice(propertyModel.getPrice());

        return pe;
    }
    public PropertyModel entityToDto(PropertyEntity propertyEntity)
    {
        PropertyModel entityToModel = new PropertyModel();
        entityToModel.setId(propertyEntity.getId());
        entityToModel.setTitle(propertyEntity.getTitle());
        entityToModel.setDescription(propertyEntity.getDescription());
        entityToModel.setOwnerName(propertyEntity.getOwnerName());
        entityToModel.setOwnerAddress(propertyEntity.getOwnerAddress());
        entityToModel.setOwnerMail(propertyEntity.getOwnerMail());
        entityToModel.setPrice(propertyEntity.getPrice());

        return entityToModel;
    }
}
