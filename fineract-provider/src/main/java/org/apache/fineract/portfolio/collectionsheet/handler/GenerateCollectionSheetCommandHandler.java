package org.apache.fineract.portfolio.collectionsheet.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.fineract.command.core.Command;
import org.apache.fineract.command.core.CommandHandler;
import org.apache.fineract.commands.service.PortfolioCommandSourceWritePlatformService;
import org.apache.fineract.portfolio.collectionsheet.data.CollectionSheetCommandParameter;
import org.apache.fineract.portfolio.collectionsheet.data.CollectionSheetRequest;
import org.apache.fineract.portfolio.collectionsheet.service.CollectionSheetReadPlatformService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class GenerateCollectionSheetCommandHandler implements CommandHandler<CollectionSheetRequest, Object> {

  private final CollectionSheetReadPlatformService collectionSheetReadPlatformService;
  private final PortfolioCommandSourceWritePlatformService commandsSourceWritePlatformService;
  
  @Transactional
  @Override
  public Object handle(Command<CollectionSheetRequest> command) {
    
    if(command.getPayload().getCommandParameter().equalsIgnoreCase(CollectionSheetCommandParameter.GENERATE_COLLECTION_SHEET.getValue())) {
      return this.collectionSheetReadPlatformService.generateIndividualCollectionSheet(command.getPayload());
    } else if(command.getPayload().getCommandParameter().equalsIgnoreCase(CollectionSheetCommandParameter.SAVE_COLLECTION_SHEET.getValue())) {
//      return this.commandsSourceWritePlatformService.logCommandSource(commandRequest);
    }
    
    return command.getPayload();
  }

}
