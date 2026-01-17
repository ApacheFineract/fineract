package org.apache.fineract.portfolio.tax.mapper;

import org.apache.fineract.accounting.glaccount.domain.GLAccountType;
import org.apache.fineract.infrastructure.core.config.MapstructMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(config = MapstructMapperConfig.class)
public interface GLAccountTypeMapper {

  @Named("intToGLAccountType")
  default GLAccountType map(Integer value) {
    return GLAccountType.fromInt(value);
  }

  @Named("glAccountTypeToInt")
  default Integer map(GLAccountType type) {
    return type == null ? null : type.getValue();
  }
}
