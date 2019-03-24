package pseudoCompiler;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class pseudoCompilerServer {
    public static void main(String[] args) throws Exception {
        pseudoCompilerImp compiler = new pseudoCompilerImp();

        LocateRegistry.createRegistry(8001);
        Naming.rebind("rmi://127.0.0.1:8001/pseudoCompiler",compiler);

        System.out.println("server started");
    }
}
