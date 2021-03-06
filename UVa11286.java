package ds;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author hkhoi
 */
public class UVa11286 {

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
            for (int n = Scan.nextInt(); n != 0; n = Scan.nextInt()) {
                HashMap<HashSet<Integer>, Integer> map = new HashMap<>();

                int maxPop = 0;
                LinkedList<HashSet<Integer>> list = new LinkedList<>();

                for (int i = 0; i < n; ++i) {
                    HashSet<Integer> set = new HashSet<>();
                    list.add(set);
                    for (int j = 0; j < 5; ++j) {
                        set.add(Scan.nextInt());
                    }

                    if (!map.containsKey(set)) {
                        map.put(set, 0);
                    }

                    int popular = map.get(set) + 1;
                    map.put(set, popular);

                    maxPop = Math.max(popular, maxPop);
                    // Each line of case
                }

                int students = 0;

                for (HashSet<Integer> it : list) {
                    if (map.get(it) == maxPop) {
                        students += 1;
                    }
                }

                out.println(students);
                // Each case
            }
        }
    }
}
