// imports a library which imports the Remote Method Invocation 
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Client {
    // default constructor
    private Client() {}

    // main client function
    public static void main(String[] args) {
        // check for host, if not there then replace with local host
        String host = (args.length < 1) ? "127.0.0.1" : args[0];
        try {
            // use lookup table to find stub
            Registry registry = LocateRegistry.getRegistry(host);
            Multiply stub = (Multiply) registry.lookup("Multiply");

            // run basic multiplication operation
            int response = stub.multiplication(3,5);
            System.out.println("response: " + response);

            // clear list from previous calls
            stub.clearList();
            
            // add to persistent list
            stub.appendToNum(response);
            stub.appendToNum(5);
            stub.appendToNum(3);

            // pop values from list
            stub.popNum();
            stub.popNum();

            // print result
            stub.printNums();

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
