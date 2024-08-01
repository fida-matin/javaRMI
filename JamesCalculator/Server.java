import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Multiplication {

    public Server() {}

    public int Multiply(int a, int b){
        return a*b;
    }

    public static void main(String args[]){

        try{
            Server obj = new Server();
            Multiplication stub = (Multiplication) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Multiplication", stub);

            System.err.println("Server Ready");

        } catch (Exception e){
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}