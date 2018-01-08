package at.muehleder.grouporders.main.data;

public class OrderPosition {
	
	private int count;
	private Item item;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	public double getPrice() {
		return item.getPrice() * count;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
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
		OrderPosition other = (OrderPosition) obj;
		if (count != other.count)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderPosition [count=" + count + ", item=" + item + ", getPrice()=" + getPrice() + "]";
	}
	
	
	

}
