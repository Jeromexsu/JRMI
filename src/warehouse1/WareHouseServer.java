package warehouse1;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class WareHouseServer {
    public static void main(String[] args) throws Exception {
        WareHouseImp centralWareHouse = new WareHouseImp();

        LocateRegistry.createRegistry(8001);
        Naming.rebind("rmi://127.0.0.1:8001/warehouse1",centralWareHouse);

        System.out.println("Server Started");

    }
}
