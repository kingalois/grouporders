import java.io.IOException;
import java.util.UUID;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.muehleder.grouporders.main.data.GroupOrder;
import at.muehleder.grouporders.main.data.GroupOrderManager;
import at.muehleder.grouporders.main.data.Item;
import at.muehleder.grouporders.main.data.Order;
import at.muehleder.grouporders.main.data.OrderPosition;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	  
	  GroupOrderManager manager = new GroupOrderManager();
		
		GroupOrder groupOrder = manager.createNewGroupOrder("Bestellung bei Pizzeria", "Pizzeria Venezia");
		System.out.println(groupOrder);
		Order order = new Order(UUID.randomUUID());
		order.setPersonName("Alois Mühleder");
		Item item = new Item("Pizza Calzone", "knusprige pizza", 7.8);
		OrderPosition pos = new OrderPosition();
		pos.setItem(item);
		pos.setCount(4);
		order.addOrUpdatePosition(pos);
		groupOrder.addOrder(order);
		System.out.println(groupOrder);
      
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    response.getWriter().print("Hello App Engine!\r\n" 
    		 + groupOrder.toString());

  }
  
  
}