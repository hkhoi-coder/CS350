package dp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Competitive Java Template Author: Khoi Hoang
 */
public class P00787 {

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
            while (true) {
                String num = Scan.next();
                if (num == null) {
                    break;
                }

                ArrayList<String> list = new ArrayList<>();

                while (!num.equals("-999999")) {
                    list.add(num);
                    num = Scan.next();
                }

                out.println(maxProduct(list));
            }
        }

        private static BigInteger maxProduct(ArrayList<String> list) {
            BigInteger max = new BigInteger(list.get(0));
            BigInteger[][] table = new BigInteger[list.size()][list.size()];

            for (int i = 0; i < table.length; ++i) {
                for (int j = i; j < table.length; ++j) {
                    if (i == j) {
                        table[i][j] = new BigInteger(list.get(i));
                    } else {
                        BigInteger current = new BigInteger(list.get(j));
                        table[i][j] = table[i][j - 1].multiply(current);
                    }

                    if (table[i][j].compareTo(max) > 0) {
                        max = table[i][j];
                    }
                }
            }

            return max;
        }
    }
}
