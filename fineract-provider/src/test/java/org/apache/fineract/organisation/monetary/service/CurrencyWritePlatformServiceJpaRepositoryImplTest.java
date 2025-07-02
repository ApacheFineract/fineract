package org.apache.fineract.organisation.monetary.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CurrencyWritePlatformServiceJpaRepositoryImplTest {
	
	@InjectMocks
	private CurrencyWritePlatformServiceJpaRepositoryImpl underTest;

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void test() {
		System.out.println("CurrencyWritePlatformServiceJpaRepositoryImplTest");
	}

}
