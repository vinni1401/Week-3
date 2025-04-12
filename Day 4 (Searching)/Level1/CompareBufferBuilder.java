public class CompareBufferBuilder {
    public static void main(String[] args) {
        int n = 1000000;
        String text = "hello";

        long start1 = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbuf.append(text);
        }
        long end1 = System.nanoTime();
        System.out.println("StringBuffer time: " + (end1 - start1) + " ns");

        long start2 = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(text);
        }
        long end2 = System.nanoTime();
        System.out.println("StringBuilder time: " + (end2 - start2) + " ns");
    }
}