package org.apache.fineract.portfolio.loanaccount.guarantor.command;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.fineract.command.core.Command;
import org.apache.fineract.portfolio.loanaccount.guarantor.data.CreateGuarantorsRequest;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateGuarantorsCommand extends Command<CreateGuarantorsRequest> {

    private static final long serialVersionUID = 1L;

}
