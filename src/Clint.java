import java.rmi.Naming;
public class Clint {  
   private Clint() {}  
   public static void main(String[] args) {  
      try {  
         IWord obj = (IWord) Naming.lookup("FindInFile"); 
         int longestWord= obj.findLongestWord(obj.processFile("..\\file.txt"));
         int shortestWord=obj.findShortestWord(obj.processFile("..\\file.txt"));
         System.out.println("Longest word: " + longestWord);
         System.out.println("Shortest word: " + shortestWord);
      } catch (Exception e) {
         System.out.println("Client exception: " + e.toString()); 
         
      } 
   } 
}