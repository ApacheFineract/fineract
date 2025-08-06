package org.apache.fineract.portfolio.collectionsheet.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.fineract.command.core.Command;
import org.apache.fineract.command.core.CommandHandler;
import org.apache.fineract.portfolio.collectionsheet.data.CollectionSheetRequest;
import org.apache.fineract.portfolio.collectionsheet.data.CollectionSheetResponse;
import org.apache.fineract.portfolio.collectionsheet.service.CollectionSheetWritePlatformService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class SaveCollectionSheetCommandHandler implements CommandHandler<CollectionSheetRequest,
        CollectionSheetResponse> {

  private final CollectionSheetWritePlatformService collectionSheetWritePlatformService;

  @Transactional
  @Override
  public CollectionSheetResponse handle(Command<CollectionSheetRequest> command) {
    return this.collectionSheetWritePlatformService.saveIndividualCollectionSheet(command);
  }
}
