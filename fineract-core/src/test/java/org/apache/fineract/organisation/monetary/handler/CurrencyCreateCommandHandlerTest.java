package org.apache.fineract.organisation.monetary.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CurrencyCreateCommandHandlerTest {
	
	@InjectMocks
	private CurrencyCreateCommandHandler underTest;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testHandle() {
		System.out.println("Create Command Unit Test Case");
	}

}
