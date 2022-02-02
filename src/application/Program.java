package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Date dateOrder = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client name: ");
		String clientName = sc.next();
		
		System.out.println("Enter client email: ");
		String clientEmail = sc.next();
		
		System.out.println("Enter client brith date: ");
		Date clientBirth = sdf.parse(sc.next());
		
		Client client = new Client(clientName, clientEmail, clientBirth);
		
		System.out.println("Enter order status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.println("How many products: ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			
			System.out.println("Enter product name: ");
			String productName = sc.next();
			
			System.out.println("Enter product price: ");
			double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.println("Quantity: ");
			double productQuantity = sc.nextDouble();
			
			System.out.println("");
			
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
			
			order.addItem(orderItem);
			
		}
		
		System.out.println(order);
		
		
		
		
		
		
		
		
		
		
		sc.close();
	}

}
