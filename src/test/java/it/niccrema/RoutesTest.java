package it.niccrema;

import org.junit.Test;

import it.niccrema.service.RoutesService;

import static org.junit.Assert.assertEquals;

public class RoutesTest {
  @Test
  public void spyRoutes() {
    RoutesService routes = new RoutesService();
    assertEquals("MNL, TAG, CEB, TAC, BOR",
        routes.findRoutes(new String[][] { { "MNL", "TAG" }, { "CEB", "TAC" }, { "TAG", "CEB" }, { "TAC", "BOR" } }));
    assertEquals("Halifax, Montreal, Toronto, Chicago, Winnipeg, Seattle",
        routes.findRoutes(new String[][] { { "Chicago", "Winnipeg" }, { "Halifax", "Montreal" },
            { "Montreal", "Toronto" }, { "Toronto", "Chicago" }, { "Winnipeg", "Seattle" } }));

  }
}
