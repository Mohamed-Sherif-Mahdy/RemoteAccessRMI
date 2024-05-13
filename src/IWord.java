import java.rmi.Remote; 
import java.rmi.RemoteException;
import java.util.List;  


public interface IWord extends Remote {  

    List<String> processFile(String filename) throws RemoteException;
    String findLongestWord(List<String> words) throws RemoteException;
    String findShortestWord(List<String> words) throws RemoteException;
} 