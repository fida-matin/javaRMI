// University of Adelaide - Distributed Systems 2024
// a1798239 Fida Matin -- a1799428 James Pham
// Collaborative Session 1

// import RMI
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Multiply extends Remote {
    // multiplying 2 numbers together and return result
    int multiplication(int num1, int num2) throws RemoteException;

    // persistent state storing numbers
    void appendToNum(int num) throws RemoteException;

    // delete last entered value
    int popNum() throws RemoteException;

    // deletes full list
    void clearList() throws RemoteException;

    // print result
    void printNums() throws RemoteException;
}

