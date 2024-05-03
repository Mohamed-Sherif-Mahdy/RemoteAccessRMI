import java.rmi.Remote; 
import java.rmi.RemoteException;
import java.util.List;  

// Creating Remote interface for our application 
public interface IWord extends Remote {  
    void printMsg()throws RemoteException;
    List<String> processFile(String filename) throws RemoteException;
    String findLongestWord(List<String> words) throws RemoteException;
    String findShortestWord(List<String> words) throws RemoteException;
} 