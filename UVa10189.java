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
public class UVa10189 {

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
            int row, col;
            int num = 1;
            boolean space = false;
            while (true) {
                row = Scan.nextInt();
                col = Scan.nextInt();

                if (row == 0 && col == 0) {
                    break;
                }

                int[][] field = new int[row][col];

                for (int i = 0; i < row; ++i) {
                    String line = Scan.nextLine();
                    for (int j = 0; j < line.length(); ++j) {
                        char ch = line.charAt(j);
                        if (ch == '*') {
                            field[i][j] = Integer.MAX_VALUE;
                            for (int r = 0; r < 3; ++r) {
                                for (int c = 0; c < 3; ++c) {
                                    if (i + r - 1 < row
                                            && i + r - 1 >= 0
                                            && j + c - 1 < col
                                            && j + c - 1 >= 0) {
                                        field[i + r - 1][j + c - 1] += 1;
                                    }
                                }
                            }
                        }
                    }
                }
                if (space) {
                    out.println();
                } else {
                    space = true;
                }
                out.printf("Field #%d:\n", num);
                num += 1;
                for (int i = 0; i < row; ++i) {
                    for (int j = 0; j < col; ++j) {
                        if (field[i][j] < 0) {
                            out.print('*');
                        } else {
                            out.print(field[i][j]);
                        }
                    }
                    out.println();
                }
            }
        }
    }
}
