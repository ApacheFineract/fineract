package org.apache.fineract.organisation.monetary.command;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.fineract.command.core.Command;
import org.apache.fineract.organisation.monetary.data.CurrencyData;

@Data
@EqualsAndHashCode(callSuper = true)
public class CurrencyCreateCommand extends Command<CurrencyData> {
  private static final long serialVersionUID = 1L;

}
