package pseudoCompiler;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface pseudoCompiler extends Remote {
     void exec(String[] name) throws RemoteException;

}
