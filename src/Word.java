// Implementing the remote interface 

import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Word implements IWord {  
   
    // Implementing the interface method 
    public void printMsg() {  
       System.out.println("This is an example RMI program");  
    }
    public List<String> processFile(String filename) throws RemoteException {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                for (String word : lineWords) {
                    words.add(word);
                }
            }
        } catch (Exception e) {
            throw new RemoteException("Error processing file: " + e.getMessage());
        }
        return words;
    }

    public String findLongestWord(List<String> words) throws RemoteException {
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    public String findShortestWord(List<String> words) throws RemoteException {
        String shortestWord = words.get(0);
        for (String word : words) {
            if (word.length() < shortestWord.length()) {
                shortestWord = word;
            }
        }
        return shortestWord;
    }  
 } 