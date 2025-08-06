package org.apache.fineract.portfolio.collectionsheet.command;

import java.io.Serial;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.fineract.command.core.Command;
import org.apache.fineract.portfolio.collectionsheet.data.CollectionSheetRequest;

@Data
@EqualsAndHashCode(callSuper = true)
public class CollectionSheetCommand extends Command<CollectionSheetRequest> {

  @Serial
  private static final long serialVersionUID = 1L;
}
