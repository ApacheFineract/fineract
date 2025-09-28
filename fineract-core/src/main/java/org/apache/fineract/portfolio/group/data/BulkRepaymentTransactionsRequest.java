package org.apache.fineract.portfolio.group.data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BulkRepaymentTransactionsRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long loanId;
    private BigDecimal transactionAmount;
    private Long paymentTypeId;
    private String note;
    private String accountNumber;
    private String checkNumber;
    private String routingCode;
    private String receiptNumber;
    private String bankNumber;
}
