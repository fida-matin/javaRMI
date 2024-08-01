// imports a library which imports the Remote Method Invocation 
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Client {
    private Client() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? "127.0.0.1" : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Multiply stub = (Multiply) registry.lookup("Multiply");
            int response = stub.multiplication(3,5);
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
