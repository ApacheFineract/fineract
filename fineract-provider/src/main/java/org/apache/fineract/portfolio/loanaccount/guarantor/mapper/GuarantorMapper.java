package org.apache.fineract.portfolio.loanaccount.guarantor.mapper;

import org.apache.fineract.infrastructure.core.config.MapstructMapperConfig;
import org.apache.fineract.portfolio.loanaccount.guarantor.data.CreateGuarantorsRequest;
import org.apache.fineract.portfolio.loanaccount.guarantor.domain.Guarantor;
import org.mapstruct.Mapping;

@org.mapstruct.Mapper(config = MapstructMapperConfig.class)
public interface GuarantorMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "loan", ignore = true)
    @Mapping(target = "clientRelationshipType", ignore = true)
    @Mapping(target = "gurantorType", source = "guarantorTypeId")
    @Mapping(target = "entityId", source = "entityId")
    @Mapping(target = "firstname", source = "firstname")
    @Mapping(target = "lastname", source = "lastname")
    @Mapping(target = "dateOfBirth", ignore = true)
    @Mapping(target = "addressLine1", source = "addressLine1")
    @Mapping(target = "addressLine2", source = "addressLine2")
    @Mapping(target = "city", source = "city")
    @Mapping(target = "state", source = "state")
    @Mapping(target = "country", source = "country")
    @Mapping(target = "zip", source = "zip")
    @Mapping(target = "housePhoneNumber", source = "housePhoneNumber")
    @Mapping(target = "mobilePhoneNumber", source = "mobileNumber")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "guarantorFundDetails", ignore = true)
    Guarantor toEntity(CreateGuarantorsRequest request);
}
