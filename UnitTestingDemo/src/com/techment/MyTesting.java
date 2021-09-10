package com.techment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyTesting {

	
	Calculation calculation = new Calculation();
	
	@Before
	void Test9()
	{
		System.out.println("before test 9");
		assertTrue(true);
	}
	
	@BeforeEach
	void Test10()
	{
        System.out.println("before all test 10");
		assertTrue(true);
	}
	
	@Test
	void test() {
		
		assertEquals(6, calculation.add(2, 4));
		 System.out.println("test 1");
		
	}
	
	@Test
	void Test2()
	{
		assertNotEquals(6, calculation.add(2, 4));
		 System.out.println("test 2");
	}

	@Test
	void EligibleTest() {
		assertEquals("eligible", calculation.checkEligibility(19));
	
		 System.out.println("test 3");
	}
	
	@Test
	void Test4()
	{
		assertTrue(calculation.name.contains("r"));
		 System.out.println("test 4");
	}
	
	@Test
	void Test5()
	{
		assertFalse(calculation.name.contains("p"));
		 System.out.println("test 5");
	}
	
	@Test
	void Test6()
	{
		//var message ="something went ";
		assertThrows(ArithmeticException.class, ()-> {int a=1;int b=0;System.out.println(a/b);});
		 System.out.println("test 6");
	}
	
	@Test
	void Test7()
	{
	
		assertThrows(IllegalArgumentException.class, ()-> {Integer.parseInt("1");});
		 System.out.println("test 7");
	}
	
	@Test
	void Test8()
	{
		
		assertThrows(IllegalArgumentException.class, ()-> {Integer.parseInt("ab");});
		 System.out.println("test 8");
	}
}
	
