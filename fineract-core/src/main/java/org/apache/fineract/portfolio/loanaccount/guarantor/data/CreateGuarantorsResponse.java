package org.apache.fineract.portfolio.loanaccount.guarantor.data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.fineract.infrastructure.core.domain.ExternalId;

@Data
@RequiredArgsConstructor
public class CreateGuarantorsResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String commandId;
    private final Long officeId;
    private final Long groupId;
    private final Long clientId;
    private final Long loanId;
    private final Long savingsId;
    private final Long resourceId;
    private final Long subResourceId;
    private final String transactionId;
    private final Map<String, Object> changes;
    private final Map<String, Object> creditBureauReportData;
    private final String resourceIdentifier;
    private final Long productId;
    private final Long gsimId;
    private final Long glimId;
    private Boolean rollbackTransaction;
    private final ExternalId resourceExternalId;
    private final ExternalId subResourceExternalId;
    private final ExternalId loanExternalId;
}
