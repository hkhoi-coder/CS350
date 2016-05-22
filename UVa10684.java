package dp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Competitive Java Template Author: Khoi Hoang
 */
public class P10684 {

    private final static boolean TEST_FILE_INPUT = true;

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
            for (int n = Scan.nextInt(); n != 0; n = Scan.nextInt()) {
                int max = 0, maxSoFar = 0;
                for (int i = 0; i < n; ++i) {
                    int num = Scan.nextInt();

                    if (i == 0) {
                        max = maxSoFar = num;
                    } else {
                        max = Math.max(num, num + max);
                        maxSoFar = Math.max(max, maxSoFar);
                    }
                }

                if (maxSoFar <= 0) {
                    out.println("Losing streak.");
                } else {
                    out.printf("The maximum winning streak is %d.\n", maxSoFar);
                }
            }
        }
    }
}
