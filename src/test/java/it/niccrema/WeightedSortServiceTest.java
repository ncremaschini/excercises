package it.niccrema;

import static org.junit.Assert.*;
import org.junit.Test;

public class WeightedSortServiceTest {
       
	@Test
	public void basicTests() {
		
        assertEquals("2000 103 123 4444 99", WeightedSortService.orderWeight("103 123 4444 99 2000"));
		assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", WeightedSortService.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
      
      	assertEquals("123 213 321", WeightedSortService.orderWeight("213 123 321"));
	}
  
    @Test(expected = RuntimeException.class)
    public void shouldThrowException_whenInvalidArguments(){
        WeightedSortService.orderWeight(null);
    }
  
    @Test(expected = NumberFormatException.class)
    public void shouldThrowException_whenInvalidNumberInArguments(){
        WeightedSortService.orderWeight("123 bla");
    }
}