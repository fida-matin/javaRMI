import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MultiplicationImplementation extends UnicastRemoteObject implements Multiplication{

    @Override
    public int Multiply(int a, int b) throws RemoteException{
        return a * b;
    }
}
