import javax.swing.*;
import java.rmi.Naming;
import java.io.File;

public class Clint {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("File Selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Select File");
        button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                processFile(selectedFile.getAbsolutePath());
            }
        });

        frame.getContentPane().add(button);
        frame.pack();
        frame.setVisible(true);
    }

    private static void processFile(String filePath) {
        try {
            IWord obj = (IWord) Naming.lookup("FindInFile");
            String longestWord = obj.findLongestWord(obj.processFile(filePath));
            String shortestWord = obj.findShortestWord(obj.processFile(filePath));
            System.out.println("Longest word: " + longestWord);
            System.out.println("Shortest word: " + shortestWord);
        } catch (Exception e) {
            System.out.println("Client exception: " + e.toString());
        }
    }
}