package warehouse2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WareHouseImp extends UnicastRemoteObject implements WareHouse {
    private Map<String,Product> products;
    private WareHouse backup;

    public WareHouseImp(WareHouse backup) throws RemoteException{
        this.backup=backup;
        products=new HashMap<>();
    }
    public void add(String keyword, Product product){
        product.setLocation(this);
        products.put(keyword,product);
    }
    public double getPrice(String description) throws RemoteException
    {
        for (Product p : products.values())
            if (p.getDescription().equals(description)) return p.getPrice();
        if (backup == null) return 0;
        else return backup.getPrice(description);
    }

    public Product getProduct(List<String> keywords) throws RemoteException
    {
        for (String keyword : keywords)
        {
            Product p = products.get(keyword);
            if (p != null) return p;
        }
        if (backup != null)
            return backup.getProduct(keywords);
        else if (products.values().size() > 0)
            return products.values().iterator().next();
        else
            return null;
    }
}
