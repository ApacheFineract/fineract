package org.apache.fineract.portfolio.loanaccount.guarantor.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.fineract.command.core.Command;
import org.apache.fineract.command.core.CommandHandler;
import org.apache.fineract.infrastructure.core.data.CommandProcessingResult;
import org.apache.fineract.portfolio.loanaccount.guarantor.data.CreateGuarantorsRequest;
import org.apache.fineract.portfolio.loanaccount.guarantor.service.GuarantorWritePlatformService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateGuarantorsCommandHandler implements CommandHandler<CreateGuarantorsRequest, CommandProcessingResult> {

    private final GuarantorWritePlatformService writePlatformService;

    @Transactional
    @Override
    public CommandProcessingResult handle(Command<CreateGuarantorsRequest> command) {
        return this.writePlatformService.createGuarantor(command);
    }
}
