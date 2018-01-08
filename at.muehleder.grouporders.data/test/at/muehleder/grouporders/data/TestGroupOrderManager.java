package at.muehleder.grouporders.data;

import java.util.UUID;

import org.junit.Test;

import at.muehleder.grouporders.main.data.GroupOrder;
import at.muehleder.grouporders.main.data.GroupOrderManager;
import at.muehleder.grouporders.main.data.Item;
import at.muehleder.grouporders.main.data.Order;
import at.muehleder.grouporders.main.data.OrderPosition;

public class TestGroupOrderManager {
	
	@Test
	public void test() {
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
		
		
		
	}

}
