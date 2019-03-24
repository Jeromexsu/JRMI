package warehouse2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface WareHouse extends Remote {
    double getPrice(String description) throws RemoteException;
    Product getProduct(List<String> keywords) throws RemoteException;

}
