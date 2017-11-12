package rmi;



import java.rmi.Naming;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;



public class Server extends UnicastRemoteObject implements CurrencyInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Server() throws RemoteException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		
	}

	
	@Override
	public Double convert(String from, String to, Double amount) throws Exception{
		Double fromUSDtoEUR = 0.5;
		Double fromEURtoGPB = 2.5;
		Double fromGPBtoUSD = 3.1;
		
		if(from.equals("USD") && to.equals("EUR")){
			return amount*fromUSDtoEUR;
		}
		if(from.equals("EUR") && to.equals("USD")){
			return amount/fromUSDtoEUR;
		}
		if(from.equals("EUR") && to.equals("GPB")){
			return amount*fromEURtoGPB;
		}
		if(from.equals("GPB") && to.equals("EUR")){
			return amount/fromEURtoGPB;
		}
		if(from.equals("GPB") && to.equals("USD")){
			return amount*fromGPBtoUSD;
		}
		if(from.equals("USD") && to.equals("GPB")){
			return amount/fromGPBtoUSD;
		}
		
		return amount;
	}

	public static void main(String[] args) {
		try {
			/*
			 * if (System.getSecurityManager() == null) {
			 * System.setSecurityManager(new SecurityManager()); }
			 */

			LocateRegistry.createRegistry(1099);

			Server server = new Server();
			Naming.rebind("//0.0.0.0/Hello", server);

			System.out.println("Server started...");

		} catch (Exception e) {
			System.out.println("Error: " + e.getLocalizedMessage());
		}

	}

}