import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Client{

    private Client(){}

        public static void main(String[] args){

            String host = (args.length < 1) ? null : args[0];

            try{
                Registry registry = LocateRegistry.getRegistry(host);
                Multiplication stub = (Multiplication) registry.lookup("Multiplication");
                int response = stub.Multiply(3, 4);
                System.out.println(response);

            } catch(Exception e){
                System.err.println("Client exception: " + e.toString());
                e.printStackTrace();
            }
        }
    }
