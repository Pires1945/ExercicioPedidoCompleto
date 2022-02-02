package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private OrderStatus status;
	private Client client;
	
	private List<OrderItem> order = new ArrayList<>();

	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrder() {
		return order;
	}

	public void addItem(OrderItem item) {
		order.add(item);
	}
	
	public void removeItem(OrderItem item) {
		order.remove(item);
	}
	
	public Double total() {
		double total = 0;
		
		for(OrderItem t : order) {
			total += t.subTotal();
		}
		
		return total;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMARY" + "\n");
		sb.append("Moment: " + sdf.format(moment)  + "\n");
		sb.append("Order Status: " + status + "\n");
		sb.append(client + "\n");
		sb.append("Order Itens: " + "\n");
		for (OrderItem itens : order) {
			sb.append(itens + "\n");
		}
		
		sb.append("Total Price: ");
		sb.append(String.format("%.2f", total()));
		
		
		
		
		
		return sb.toString();
	}
	
}
