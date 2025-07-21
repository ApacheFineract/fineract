package org.apache.fineract.portfolio.loanaccount.guarantor.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.fineract.command.core.Command;
import org.apache.fineract.command.core.CommandHandler;
import org.apache.fineract.infrastructure.core.data.CommandProcessingResult;
import org.apache.fineract.portfolio.loanaccount.guarantor.data.DeleteGuarantorsRequest;
import org.apache.fineract.portfolio.loanaccount.guarantor.service.GuarantorWritePlatformService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteGuarantorsCommandHandler implements CommandHandler<DeleteGuarantorsRequest, CommandProcessingResult> {

    private final GuarantorWritePlatformService writePlatformService;

    @Override
    public CommandProcessingResult handle(Command<DeleteGuarantorsRequest> command) {
        return this.writePlatformService.removeGuarantor(command.getPayload().getLoanId(), command.getPayload().getGuarantorId(),
                command.getPayload().getGuarantorFundingId());
    }

}
