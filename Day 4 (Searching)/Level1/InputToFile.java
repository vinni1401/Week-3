import java.io.*;

public class InputToFile {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter output file path: ");
        String filePath = reader.readLine();

        FileWriter fw = new FileWriter(filePath);
        String input;
        System.out.println("Enter text (type 'exit' to finish):");

        while (true) {
            input = reader.readLine();
            if (input.equals("exit")) {
                break;
            }
            fw.write(input + "\n");
        }
        fw.close();
        System.out.println("Data written to file.");
    }
}