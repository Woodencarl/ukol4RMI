
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface CurrencyInterface extends Remote {
		

	public Double convert(String from, String to, Double amount) throws Exception;
}
