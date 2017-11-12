package rmi;

import java.rmi.Naming;

public class Client {

	public static void main(String[] args) throws Exception {
		CurrencyInterface client = (CurrencyInterface) Naming.lookup("//localhost/Hello");
		Double amount = 100.0;
		System.out.println("Started with 100 USD");
		amount = client.convert("USD", "GPB", amount);
		System.out.println("Changed them to GPB: "+ amount);
		amount = client.convert("GPB", "EUR", amount);
		System.out.println("Changed them to EUR: "+ amount);
		amount = client.convert("EUR", "USD", amount);
		System.out.println("Changed them to USD: "+ amount);
		
		System.out.println("Lets try other way with that amount, shoudl get same result!");
		System.out.println("Started with "+amount+" USD");
		
		amount = client.convert("USD", "EUR", amount);
		System.out.println("Changed them to EUR: "+ amount);
		amount = client.convert("EUR", "GPB", amount);
		System.out.println("Changed them to GPB: "+ amount);
		amount = client.convert("GPB", "USD", amount);
		System.out.println("Changed them to USD: "+ amount);
		
		System.out.println("Lets try to EUR and back!");
		amount=100.0;
		System.out.println("Started with 100 USD");
		amount = client.convert("USD", "EUR", amount);
		System.out.println("Changed them to EUR: "+ amount);
		amount = client.convert("EUR", "USD", amount);
		System.out.println("Changed them to USD: "+ amount);
		
	}

}
