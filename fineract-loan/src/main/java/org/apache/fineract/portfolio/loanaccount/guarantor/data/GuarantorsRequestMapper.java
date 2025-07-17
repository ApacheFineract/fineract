package org.apache.fineract.portfolio.loanaccount.guarantor.data;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GuarantorsRequestMapper {

  GuarantorsRequestMapper INSTANCE = Mappers.getMapper(GuarantorsRequestMapper.class);

  CreateGuarantorsRequest toCreateRequest(GuarantorsRequest source);

  GuarantorsRequest fromCreateRequest(CreateGuarantorsRequest source);

}
