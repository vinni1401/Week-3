import java.io.*;

public class ChallengeComparison {
    public static void main(String[] args) throws IOException {
   
        String str = "hello";
        int times = 1000000;

        long sbStart = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        long sbEnd = System.nanoTime();
        System.out.println("StringBuilder time: " + (sbEnd - sbStart) + " ns");

        long sbufStart = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < times; i++) {
            sbuf.append(str);
        }
        long sbufEnd = System.nanoTime();
        System.out.println("StringBuffer time: " + (sbufEnd - sbufStart) + " ns");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter large file path: ");
        String path = br.readLine();

        FileReader fr = new FileReader(path);
        BufferedReader reader1 = new BufferedReader(fr);
        String line;
        int wordCount = 0;
        while ((line = reader1.readLine()) != null) {
            String[] words = line.trim().split("\\s+");
            wordCount += words.length;
        }
        reader1.close();
        System.out.println("Total words (FileReader): " + wordCount);

        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader reader2 = new BufferedReader(isr);
        wordCount = 0;
        while ((line = reader2.readLine()) != null) {
            String[] words = line.trim().split("\\s+");
            wordCount += words.length;
        }
        reader2.close();
        System.out.println("Total words (InputStreamReader): " + wordCount);
    }
}
