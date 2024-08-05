import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server implements Multiply {
    // default constructor
    public Server() {}

    // basic multiplication operation
    public int multiplication(int num1, int num2) {
        return num1 * num2;
    }

    // array list for persistent state operations
    private ArrayList<Integer> numList = new ArrayList<Integer>();

    // appends to list
    public void appendToNum(int num) {
        numList.add(num);
    }

    // pop last value in list
    public int popNum() {
        int index = numList.size() - 1;
        int num = numList.get(index);
        numList.remove(index);
        return num;
    }

    // clear list
    public void clearList() {
        numList.clear();
    }

    // print list
    public void printNums() {
        System.out.println(numList);
    } 

    // main server function
    public static void main(String args[]) {
        try {
            Server stubInstance = new Server();
            Multiply stub = (Multiply) UnicastRemoteObject.exportObject(stubInstance, 0);
    
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();

            // check if registry already bound then rebind instead
            try{
                registry.bind("Multiply", stub);
            } catch (Exception e) {
                registry.rebind("Multiply", stub);
            }
            
            // print once server setup is successful
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
