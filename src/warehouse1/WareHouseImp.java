package warehouse1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class WareHouseImp extends UnicastRemoteObject implements WareHouse {
    private Map<String,Double> prices;

    public WareHouseImp() throws RemoteException{
        prices = new HashMap<>();
        prices.put("Toaster",29.5);
        prices.put("Mobile",400.0);
    }
    @Override
    public double getPrice(String description) throws RemoteException {
        Double price = prices.get(description);
        System.out.println("test");
        return price==null?0:price;
    }
}
