package ltd.boxin.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHello extends Remote {
    public String satHello(String name) throws RemoteException;
}
