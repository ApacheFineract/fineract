package org.apache.fineract.portfolio.loanaccount.guarantor.command;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.fineract.command.core.Command;
import org.apache.fineract.portfolio.loanaccount.guarantor.data.DeleteGuarantorsRequest;

@Data
@EqualsAndHashCode(callSuper = true)
public class DeleteGuarantorsCommand extends Command<DeleteGuarantorsRequest> {
  private static final long serialVersionUID = 1L;

}
