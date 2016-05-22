package adhoc;

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
public class UVa10114 {

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

    private final static boolean TEST_FILE_INPUT = true;

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
                int duration = Scan.nextInt();
                double downPayment = Scan.nextDouble();
                double amount = Scan.nextDouble();
                int records = Scan.nextInt();

                if (duration <= 0) {
                    break;
                }

                double[] deprecation = new double[duration];
                for (int i = 0; i < records; ++i) {
                    int month = Scan.nextInt();
                    double value = Scan.nextDouble();

                    for (int j = month; j < duration; ++j) {
                        deprecation[j] = value;
                    }
                }

                int now = 0;
                double monthlyPayment = amount / duration;
                double curVal = (amount + downPayment) * (1 - deprecation[0]);
                double curLoan = amount;
                while (curVal < curLoan) {
                    try {
                        now++;
                        curLoan -= monthlyPayment;
                        curVal = curVal * (1 - deprecation[now]);
                    } catch (Exception e) {
                        break;
                    }
                }

                if (now == 1) {
                    out.println("1 month");
                } else {
                    out.printf("%d months\n", now);
                }
            }
        }
    }
}
