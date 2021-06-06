package com.springboot.tutorial;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.tutorial.logic.Calculation;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
		final Calculation calculation = new Calculation();
		
		assertEquals(350, calculation.getTotalAmountForProduct(40,
    			175,20,"unit"));
		
	}

}
