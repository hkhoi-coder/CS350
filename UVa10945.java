package adhoc;

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
public class UVa10945 {

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
                String cur = Scan.nextLine();
                if (cur.equals("DONE")) {
                    break;
                }

                StringBuilder sb = new StringBuilder();
                for (char c : cur.toCharArray()) {
                    if (Character.isAlphabetic(c)) {
                        sb.append(c);
                    }
                }

                String processed = sb.toString().toLowerCase();
                if (isPalindrome(processed)) {
                    out.println("You won't be eaten!");
                } else {
                    out.println("Uh oh..");
                }
            }
        }

        private static boolean isPalindrome(String processed) {
            int i = 0, j = processed.length() - 1;

            while (i < j) {
                if (processed.charAt(i) != processed.charAt(j)) {
                    return false;
                }
                ++i;
                --j;
            }

            return true;
        }
    }
}
