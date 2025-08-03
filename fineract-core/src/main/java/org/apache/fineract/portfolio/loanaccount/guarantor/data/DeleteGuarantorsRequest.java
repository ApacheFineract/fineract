package org.apache.fineract.portfolio.loanaccount.guarantor.data;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.PositiveOrZero;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteGuarantorsRequest implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long loanId;
  private Long guarantorId;
  private Long guarantorFundingId;
}
