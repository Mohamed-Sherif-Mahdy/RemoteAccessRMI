import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Word extends UnicastRemoteObject implements IWord {  
 public Word() throws Exception{
    super();
 }
    public List<String> processFile(String filename) throws RemoteException {
        List<String> words = new ArrayList<>();
        String regexPattern = "[^a-zA-Z]";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                for (String word : lineWords) {
                    words.add(word.replaceAll(regexPattern, ""));
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
            if (word.length() < shortestWord.length() && word.length() > 0){
                shortestWord = word;
            }
        }
        return shortestWord;
    }   
 } 