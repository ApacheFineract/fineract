package org.apache.fineract.organisation.monetary.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.fineract.infrastructure.core.domain.AbstractPersistableCustom;
import org.apache.fineract.organisation.monetary.data.CurrencyData;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_currency")
public class CreateCurrency extends AbstractPersistableCustom<Long> {
  private static final long serialVersionUID = 1L;

  @Column(name = "code", nullable = false, length = 3)
  public String code;

  @Column(name = "name", nullable = false, length = 50)
  public String name;

  @Column(name = "decimal_places", nullable = false)
  public Integer decimalPlaces;

  @Column(name = "currency_multiplesof")
  public Integer inMultiplesOf;

  @Column(name = "display_symbol", nullable = true, length = 10)
  public String displaySymbol;

  @Column(name = "internationalized_name_code", nullable = false, length = 50)
  public String nameCode;

  public static CreateCurrency fromCurrencyData(CurrencyData currencyData) {
      return CreateCurrency.builder().code(currencyData.getCode()).name(currencyData.getName())
              .decimalPlaces(currencyData.getDecimalPlaces()).inMultiplesOf(currencyData.getInMultiplesOf())
              .displaySymbol(currencyData.getDisplaySymbol()).nameCode(currencyData.getNameCode()).build();
  }

  public static CurrencyData toCurrencyData(CreateCurrency createCurrencyData) {
      return CurrencyData.builder().code(createCurrencyData.getCode()).name(createCurrencyData.getName())
              .decimalPlaces(createCurrencyData.getDecimalPlaces()).inMultiplesOf(createCurrencyData.getInMultiplesOf())
              .displaySymbol(createCurrencyData.getDisplaySymbol()).nameCode(createCurrencyData.getNameCode()).build();
  }
}
