import java.rmi.Naming;


public class Server extends Word { 
   
   public Server() throws Exception {
      super();
     
   }

   public static void main(String args[]) { 
      try { 
         Word obj = new Word(); 
         Naming.rebind("FindInFile", obj);  
         System.out.println("Server ready"); 
      } catch (Exception e) { 
         System.out.println("Server exception: " + e.toString()); 
         
      } 
   } 
}