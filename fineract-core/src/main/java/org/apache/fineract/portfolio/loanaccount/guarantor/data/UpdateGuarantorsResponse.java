package org.apache.fineract.portfolio.loanaccount.guarantor.data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateGuarantorsResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID commandId;
    private Long officeId;
    private Long loanId;
    private Long entityId;
    private Map<String, Object> changesOnly;
}
