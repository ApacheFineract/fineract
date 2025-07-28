package org.apache.fineract.organisation.monetary.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.apache.fineract.organisation.monetary.data.CurrencyCreateRequest;
import org.apache.fineract.organisation.monetary.data.CurrencyCreateResponse;
import org.apache.fineract.organisation.monetary.domain.ApplicationCurrency;
import org.apache.fineract.organisation.monetary.domain.ApplicationCurrencyRepositoryWrapper;
import org.apache.fineract.organisation.monetary.mapper.CurrencyMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CurrencyWritePlatformServiceJpaRepositoryImplTest {

    private List<CurrencyCreateRequest> currenciesGood;

    @InjectMocks
    private CurrencyWritePlatformServiceJpaRepositoryImpl underTest;

    @Mock
    private ApplicationCurrencyRepositoryWrapper applicationCurrencyRepository;

    @Mock
    private CurrencyMapper currencyMapper;

    @BeforeEach
    void setUp() throws Exception {
        currenciesGood = List.of(
                CurrencyCreateRequest.builder().code("AAA").decimalPlaces(0).inMultiplesOf(1).displaySymbol("∑").name("Currency1")
                        .nameCode("currency.AAA").build(),

                CurrencyCreateRequest.builder().code("AAB").decimalPlaces(1).inMultiplesOf(10).displaySymbol("∏").name("Currency2")
                        .nameCode("currency.AAB").build(),

                CurrencyCreateRequest.builder().code("AAC").decimalPlaces(2).inMultiplesOf(1000).displaySymbol("∅").name("Currency3")
                        .nameCode("currency.AAC").build(),

                CurrencyCreateRequest.builder().code("AAD").decimalPlaces(3).inMultiplesOf(0).displaySymbol("∞").name("Currency4")
                        .nameCode("currency.AAD").build());
    }

    @Test
    void testHappyPathForGoodData() {
        for (CurrencyCreateRequest element : currenciesGood) {
            ApplicationCurrency currency = currencyMapper.mapToEntity(element);
            Mockito.when(applicationCurrencyRepository.save(Mockito.refEq(currency))).thenReturn(currency);
            CurrencyCreateResponse response = currencyMapper.mapToResponse(currency);
            assertEquals(underTest.createCurrency(element), response);
        }
    }
}
