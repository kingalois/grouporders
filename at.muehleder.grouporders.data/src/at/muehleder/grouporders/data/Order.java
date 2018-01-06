package at.muehleder.grouporders.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class Order {
	
	private final UUID uuid;
	private List<OrderPosition> positions = new ArrayList<>();
	private boolean finished = false;
	private String personName;
	
	public Order(UUID uuid) {
		this.uuid = uuid;
	}

	public void addOrUpdatePosition(OrderPosition position) {
		positions.remove(position);
		positions.add(position);
	}
	
	public void removePosition(OrderPosition position) {
		positions.remove(position);
	}
	
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
		Order other = (Order) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	public double getPrice() {
		double price = 0;
		for (OrderPosition pos : positions) {
			price = price + pos.getPrice();
		}
		return price;
	}

	@Override
	public String toString() {
		return "Order [uuid=" + uuid + ", positions=" + positions + ", finished=" + finished + ", personName="
				+ personName + ", getPrice()=" + getPrice() + "]";
	}
	
	
	
	

}
