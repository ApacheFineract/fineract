package org.apache.fineract.portfolio.loanaccount.guarantor.data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteGuarantorsResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID commandId;
    private Long officeId;
    private Long loanId;
    private Long resourceId;
}
