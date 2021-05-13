package it.niccrema;

import org.junit.Test;

import it.niccrema.service.CalculateRotationService;

import static org.junit.Assert.assertEquals;

public class CalculateRotationServiceTest {

  @Test(expected = RuntimeException.class)
  public void shouldThrowException_whenFirstArgumentIsNull() {
    CalculateRotationService.shiftedDiff(null, "pooh");
  }

  @Test(expected = RuntimeException.class)
  public void shouldThrowException_whenSecondArgumentIsNull() {
    CalculateRotationService.shiftedDiff("hoop", null);
  }

  @Test
  public void testBasicCases() {
    assertEquals(-1, CalculateRotationService.shiftedDiff("hoop", "pooh"));
    assertEquals(2, CalculateRotationService.shiftedDiff("coffee", "eecoff"));
    assertEquals(4, CalculateRotationService.shiftedDiff("eecoff", "coffee"));
    assertEquals(0, CalculateRotationService.shiftedDiff("eecoff", "eecoff"));
  }
}