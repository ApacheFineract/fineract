package org.apache.fineract.organisation.monetary.handler;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import org.apache.fineract.infrastructure.core.service.DateUtils;
import org.apache.fineract.command.core.Command;
import org.apache.fineract.organisation.monetary.data.CurrencyData;
import org.apache.fineract.organisation.monetary.service.CurrencyWritePlatformService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class CurrencyCreateCommandHandlerTest {
  private List<CurrencyData> currenciesGood;

  @InjectMocks
  private CurrencyCreateCommandHandler underTest;

  @Mock
  private CurrencyWritePlatformService writePlatformService;

  @BeforeEach
  void setUp() throws Exception {
      ObjectMapper objectMapper = new ObjectMapper();
      InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test-resources/currenciesGoodData.json");

      currenciesGood = objectMapper.readValue(inputStream, new TypeReference<List<CurrencyData>>() {});
  }

  @Test
  void testHandleHappyPath() {
      for (CurrencyData element : currenciesGood) {
          Command<CurrencyData> command = new Command<>();
          command.setId(UUID.randomUUID());
          command.setCreatedAt(DateUtils.getAuditOffsetDateTime());
          command.setPayload(element);
          Mockito.when(writePlatformService.createCurrency(command.getPayload())).thenReturn(element);
          assertThat(underTest.handle(command)).isEqualTo(element);
      }
  }
}
