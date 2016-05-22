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
public class UVa11507 {

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
            int instructions;
            while (true) {
                instructions = Scan.nextInt();
                if (instructions == 0) {
                    break;
                }

                String status = "+x";
                for (int i = 0; i < instructions - 1; ++i) {
                    String instruction = Scan.next();
                    switch (instruction) {
                        case "+y":
                            switch (status) {
                                case "+x":
                                    status = "+y";
                                    break;
                                case "-x":
                                    status = "-y";
                                    break;
                                case "+y":
                                    status = "-x";
                                    break;
                                case "-y":
                                    status = "+x";
                                    break;
                            }
                            break;
                        case "-y":
                            switch (status) {
                                case "+x":
                                    status = "-y";
                                    break;
                                case "-x":
                                    status = "+y";
                                    break;
                                case "+y":
                                    status = "+x";
                                    break;
                                case "-y":
                                    status = "-x";
                                    break;
                            }
                            break;
                        case "+z":
                            switch (status) {
                                case "+x":
                                    status = "+z";
                                    break;
                                case "-x":
                                    status = "-z";
                                    break;
                                case "+z":
                                    status = "-x";
                                    break;
                                case "-z":
                                    status = "+x";
                                    break;
                            }
                            break;
                        case "-z":
                            switch (status) {
                                case "+x":
                                    status = "-z";
                                    break;
                                case "-x":
                                    status = "+z";
                                    break;
                                case "+z":
                                    status = "+x";
                                    break;
                                case "-z":
                                    status = "-x";
                                    break;
                            }
                            break;
                    }
                }
                out.println(status);
            }
        }
    }
}
