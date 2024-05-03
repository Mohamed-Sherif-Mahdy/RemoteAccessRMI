import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;
import java.util.List;  

public class Clint {  
   private Clint() {}  
   public static void main(String[] args) {  
      try {  
         // Getting the registry 
         Registry registry = LocateRegistry.getRegistry(null); 
    
         // Looking up the registry for the remote object 
         IWord stub = (IWord) registry.lookup("Hello"); 
    
         // Calling the remote method using the obtained object 
         stub.printMsg();
         
         String longestWord=stub.findLongestWord(stub.processFile("file.txt"));
         String shortestWord=stub.findShortestWord(stub.processFile("file.txt"));
         System.out.println("Longest word: " + longestWord);
         System.out.println("Shortest word: " + shortestWord);
         // System.out.println("Remote method invoked"); 
      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}