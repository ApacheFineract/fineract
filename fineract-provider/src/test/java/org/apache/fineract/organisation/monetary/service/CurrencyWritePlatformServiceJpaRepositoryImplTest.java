package org.apache.fineract.organisation.monetary.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.InputStream;
import java.util.List;
import org.apache.fineract.organisation.monetary.data.CurrencyData;
import org.apache.fineract.organisation.monetary.domain.CreateCurrency;
import org.apache.fineract.organisation.monetary.domain.CreateCurrencyRepository;
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
class CurrencyWritePlatformServiceJpaRepositoryImplTest {

	private List<CurrencyData> currenciesGood;
	private List<CurrencyData> currenciesCorrupted;

	@InjectMocks
	private CurrencyWritePlatformServiceJpaRepositoryImpl underTest;

	@Mock
	private CreateCurrencyRepository createCurrencyRepository;

	@BeforeEach
	void setUp() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream("test-resources/currenciesGoodData.json");

		currenciesGood = objectMapper.readValue(inputStream, new TypeReference<List<CurrencyData>>() {
		});

		inputStream = getClass().getClassLoader()
				.getResourceAsStream("test-resources/currenciesCorruptedData.json");

		currenciesCorrupted = objectMapper.readValue(inputStream,
				new TypeReference<List<CurrencyData>>() {
				});
	}

	@Test
	void testHappyPathForGoodData() {
		System.out.println("Currency Happy Path");
		for (CurrencyData element : currenciesGood) {
			CreateCurrency currency = CreateCurrency.fromCurrencyData(element);
			Mockito.when(createCurrencyRepository.save(Mockito.refEq(currency))).thenReturn(currency);
			System.out.println("Currently Testing: " + element.getCode() + " Currency.");
			System.out.println();
			assertThat(underTest.createCurrency(element)).isEqualTo(element);
		}
	}

	@Test
	void testCorruptedDataShouldThrowException() {
		System.out.println("Currency Corrupted Data");

		for (CurrencyData element : currenciesCorrupted) {
			System.out.println("Currently Testing: " + element.getCode() + " Currency.");

			Throwable thrown = assertThrows(Throwable.class, () -> {
				underTest.createCurrency(element);
			});
			System.out
					.println("Caught: " + thrown.getClass().getSimpleName() + " - " + thrown.getMessage());
			System.out.println();
		}
	}
}
