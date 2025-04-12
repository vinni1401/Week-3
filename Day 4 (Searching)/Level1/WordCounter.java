import java.io.*;

public class WordCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter file path: ");
        String filePath = br.readLine();
        System.out.print("Enter word to search: ");
        String word = br.readLine();

        FileReader fr = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fr);
        String line;
        int count = 0;

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word)) {
                    count++;
                }
            }
        }
        reader.close();
        System.out.println("Word count: " + count);
    }
}
