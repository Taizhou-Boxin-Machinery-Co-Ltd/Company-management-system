package ltd.boxin.api;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements IHello {
    protected HelloImpl() throws RemoteException {
        super();
    }

    @Override
    public String satHello(String name) throws RemoteException {
        System.out.println("hello" + name);
        return name + ": hello";
    }
}
