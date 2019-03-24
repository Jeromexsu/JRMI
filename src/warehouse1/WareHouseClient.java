package warehouse1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

public class WareHouseClient {
    public static void main(String[] args) throws NamingException, RemoteException {
        Context namingContext = new InitialContext();
        String url="rmi://127.0.0.1:8001/warehouse1";
        WareHouse centralWarehouse = (WareHouse)namingContext.lookup(url);

        double price = centralWarehouse.getPrice("Toaster");
        System.out.println(price);
    }
}
