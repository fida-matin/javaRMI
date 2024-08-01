import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Multiply {
    public Server() {}

    public int multiplication(int num1, int num2) {
        return num1 * num2;
    }

    public static void main(String args[]) {
        try {
            Server stubInstance = new Server();
            Multiply stub = (Multiply) UnicastRemoteObject.exportObject(stubInstance, 0);
    
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Multiply", stub);
    
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
