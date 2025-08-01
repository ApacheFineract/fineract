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

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@FieldNameConstants
public class DeleteGuarantorsRequest implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @PositiveOrZero(message = "{guarantor.loanId.positiveOrZero}")
  @Digits(integer = 10, fraction = 0, message = "{guarantor.loanId.digits}")
  private Long loanId;

  @PositiveOrZero(message = "{guarantor.guarantorId.positiveOrZero}")
  @Digits(integer = 10, fraction = 0, message = "{guarantor.guarantorId.digits}")
  private Long guarantorId;

  @PositiveOrZero(message = "{guarantor.guarantorFundingId.positiveOrZero}")
  @Digits(integer = 10, fraction = 0, message = "{guarantor.guarantorFundingId.digits}")
  private Long guarantorFundingId;
}
