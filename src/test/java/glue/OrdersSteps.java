package glue;

import io.cucumber.java.en.When;
import javax.inject.Inject;
import screens.order.OrderDetailsScreen;
import screens.order.OrdersScreen;

public class OrdersSteps {

  @Inject
  private OrdersScreen ordersScreen;

  @Inject
  private OrderDetailsScreen orderDetailsScreen;
  @When("Dash Shipper search orders with the text: {string} in orders screen")
  public void dashShipperSearchOrdersWithTheTextInOrdersScreen(String searchText) {
    //ordersScreen.searchOrder(searchText);
    ordersScreen.tabOnAnyOrderInList();

    orderDetailsScreen.cancelOrder();
  }

}
