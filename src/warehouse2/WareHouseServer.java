package warehouse2;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class WareHouseServer
{
    public static void main(String[] args) throws Exception
    {
        //server policy file should be put in the workspace
        System.setProperty("java.security.policy", "server.policy");
        System.setSecurityManager(new SecurityManager());

        System.out.println("Constructing server implementation...");
        WareHouseImp backupWarehouse = new WareHouseImp(null);
        WareHouseImp centralWarehouse = new WareHouseImp (backupWarehouse);

        centralWarehouse.add("toaster", new Product("Blackwell Toaster", 23.95));
        backupWarehouse.add("java", new Book("Core Java vol. 2", "0132354799", 44.95));

        System.out.println("Binding server implementation to registry...");
//      Context namingContext = new InitialContext();
//      namingContext.bind("rmi:central_warehouse", centralWarehouse);
        LocateRegistry.createRegistry(8001);//定义端口号
        Naming.rebind("rmi://127.0.0.1:8001/warehouse2", centralWarehouse);

        System.out.println("Waiting for invocations from clients...");
    }
}
