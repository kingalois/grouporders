package at.muehleder.grouporders.data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroupOrder {
	
	private final UUID groupOrderId;
	private String groupOrderName;
	private String orderDestination;
	private List<Order> orders = new ArrayList<>();
	

	public GroupOrder(UUID groupOrderId, String groupOrderName, String orderDestination) {
		this.groupOrderId = groupOrderId;
		this.groupOrderName = groupOrderName;
		this.orderDestination = orderDestination;
	}


	public UUID getGroupOrderId() {
		return groupOrderId;
	}


	public String getGroupOrderName() {
		return groupOrderName;
	}


	public String getOrderDestination() {
		return orderDestination;
	}
	
	public List<Order> getOrders(){
		return orders;
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}
	
	public boolean isFinished() {
		if(orders.isEmpty()) {
			return false;
		}
		for(Order order : orders) {
			if(!order.isFinished()) {
				return false;
			}
		}
		return true;
	}
	
	public double getPrice() {
		double price = 0;
		for(Order order : orders) {
			price = price + order.getPrice();
		}
		
		return price;
	}


	

	@Override
	public String toString() {
		return "GroupOrder [groupOrderId=" + groupOrderId + ", groupOrderName=" + groupOrderName + ", orderDestination="
				+ orderDestination + ", orders=" + orders + ", isFinished()=" + isFinished() + ", getPrice()="
				+ getPrice() + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupOrderId == null) ? 0 : groupOrderId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupOrder other = (GroupOrder) obj;
		if (groupOrderId == null) {
			if (other.groupOrderId != null)
				return false;
		} else if (!groupOrderId.equals(other.groupOrderId))
			return false;
		return true;
	}


	
	
	
	
	
	
	
	

}
