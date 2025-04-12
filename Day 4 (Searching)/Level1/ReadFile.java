import java.io.*;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter file path: ");
        String filePath = br.readLine();

        FileReader fr = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fr);
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}