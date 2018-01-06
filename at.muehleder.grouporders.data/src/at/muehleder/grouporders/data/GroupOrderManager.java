package at.muehleder.grouporders.data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GroupOrderManager {
	
	Map<UUID, GroupOrder> groupOrders = new HashMap<>();
	
	
	public GroupOrder createNewGroupOrder(String groupOrderName, String orderDestination) {
		GroupOrder order = new GroupOrder(UUID.randomUUID(), groupOrderName, orderDestination);
		groupOrders.put(order.getGroupOrderId(), order);
		return order;	
	}
	
	public GroupOrder getGroupOrder(UUID orderId) {
		return groupOrders.get(orderId);
	}

}
