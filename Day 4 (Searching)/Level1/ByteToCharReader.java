import java.io.*;

public class ByteToCharReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter file path: ");
        String filePath = br.readLine();

        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader reader = new BufferedReader(isr);
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}