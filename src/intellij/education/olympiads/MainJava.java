package intellij.education.olympiads;

import java.lang.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class MainJava {

    public static void main(String[] args) {
        new MainJava().run();
    }

    private void solve() {
        out.println("Hello, world!");
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    private long sqrtLong(long x) {
        long root = (long) Math.sqrt(x);
        while (root * root > x) --root;
        while ((root + 1) * (root + 1) <= x) ++root;
        return root;
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    private long readLong() {
        return Long.parseLong(Objects.requireNonNull(readString()));
    }

    private int readInt() {
        return Integer.parseInt(Objects.requireNonNull(readString()));
    }

    private char readChar() {
        return Objects.requireNonNull(readString()).charAt(0);
    }

    private double readDouble() {
        return Double.parseDouble(Objects.requireNonNull(readString()));
    }

    private short readShort() {
        return Short.parseShort(Objects.requireNonNull(readString()));
    }

    private BigInteger readBigInteger() {
        return BigInteger.valueOf(readLong());
    }

    private int[] readIntArray(int size) {
        int[] result = new int[size];
        for (int index = 0; index < size; index++) { result[index] = readInt(); }
        return result;
    }

    private long[] readLongArray(int size) {
        long[] result = new long[size];
        for (int index = 0; index < size; index++) { result[index] = readLong(); }
        return result;
    }

    private String readString() {
        while (!tok.hasMoreTokens()) {
            String nextLine = readLine();
            if (null == nextLine) return null;
            tok = new StringTokenizer(nextLine);
        }

        return tok.nextToken();
    }

    private String readLine() {
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    private BufferedReader in;
    private StringTokenizer tok;
    private PrintWriter out;

    private void initFileIO(String inputFileName, String outputFileName) throws FileNotFoundException {
        in = new BufferedReader(new FileReader(inputFileName));
        out = new PrintWriter(outputFileName);
    }

    private void initConsoleIO() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    private void initIO() throws IOException {
        Locale.setDefault(Locale.US);

        String fileName = "";

        if (!fileName.isEmpty()) {
            initFileIO(fileName + ".in", fileName + ".out");
        } else {
            if (new File("input.txt").exists()) {
                initFileIO("input.txt", "output.txt");
            } else {
                initConsoleIO();
            }
        }

        tok = new StringTokenizer("");
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    private void run() {
        try {
            initIO(); solve();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}