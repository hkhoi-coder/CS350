package dp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author hkhoi
 */
public class UVa00357 {
    private final static boolean TEST_FILE_INPUT = false;

    static PrintWriter out;
    static BufferedReader in;
    static StringTokenizer token;

    public static void main(String[] args) throws IOException {
        Solution.run();
        out.close();
    }

    private static class Scan {

        public static String next() throws IOException {
            try {
                while (token == null || !token.hasMoreTokens()) {
                    token = new StringTokenizer(in.readLine());
                }
                return token.nextToken();
            } catch (NullPointerException e) {
                return null;
            }
        }

        public static String nextLine() throws IOException {
            try {
                String line = in.readLine();
                while (line.isEmpty()) {
                    line = in.readLine();
                }
                return line;
            } catch (NullPointerException e) {
                return null;
            }
        }

        public static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public static long nextLong() throws IOException {
            return Integer.parseInt(next());
        }

        public static float nextFloat() throws IOException {
            return Float.parseFloat(next());
        }

        public static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public static int nextChar() throws IOException {
            return in.read();
        }
    }

    static {
        try {
            out = new PrintWriter(System.out);
            if (TEST_FILE_INPUT) {
                in = new BufferedReader(new FileReader("in"));    // File input
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
            }
        } catch (FileNotFoundException ex) {
            // Ignore
        }
    }

    public static class Solution {

        public static void run() throws IOException {

            int[] currency = {1, 5, 10, 25, 50};

            for (String line = Scan.nextLine(); line != null; line = Scan.nextLine()) {
                int num = Integer.parseInt(line);
                long[] table = new long[num + 1];
                table[0] = 1;

                for (int i : currency) {
                    for (int j = i; j <= num; ++j) {
                        table[j] += table[j - i];
                    }
                }

                if (table[num] == 1) {
                    out.printf("There is only 1 way to produce %d cents change.\n", num);
                } else {
                    out.printf("There are %d ways to produce %d cents change.\n", table[num], num);
                }
            }
        }
    }
}
