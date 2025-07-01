package org.apache.fineract.organisation.monetary.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.fineract.command.core.Command;
import org.apache.fineract.command.core.CommandHandler;
import org.apache.fineract.organisation.monetary.data.CurrencyData;
import org.apache.fineract.organisation.monetary.service.CurrencyWritePlatformService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class CurrencyCreateCommandHandler implements CommandHandler<CurrencyData, CurrencyData>{

	private final CurrencyWritePlatformService writePlatformService;

	@Transactional
	@Override
	public CurrencyData handle(Command<CurrencyData> command) {
		return writePlatformService.createCurrency(command.getPayload());
	}

}
