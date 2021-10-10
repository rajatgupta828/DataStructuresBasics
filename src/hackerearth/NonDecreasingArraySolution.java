package hackerearth;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Main
 */
class NonDecreasingSolution {
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();

            final FastPrinter fp = new FastPrinter(System.out);
            final FastReader fr = new FastReader(System.in);

            Solution solver = new Solution(fp, fr);

            boolean multipleTC = true;
            int test = 1;

            if (multipleTC) {
                test = fr.nextInt();
            }

            while (test-- > 0) {
                // Write code..
                solver.solve();
            }

            solver.printAns();

            long endTime = System.currentTimeMillis();
            if (System.getProperty("ONLINE_JUDGE") == null) {
                // fp.println("Time: " + (endTime - startTime) + " ms");
            }

            fp.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * Solution
 */
class Solution {

    private final FastPrinter fPrinter;
    private final FastReader fReader;

    private final StringBuilder ans;

    public Solution(FastPrinter _fPrinter, FastReader _fReader) {
        fReader = _fReader;
        fPrinter = _fPrinter;
        ans = new StringBuilder();
    }

    public void solve() throws IOException {
        int n = fReader.nextInt();
        int[] arr = new int[n];
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                arr[i] = fReader.nextInt();
                res[i] = arr[i];
            } else {
                arr[i] = fReader.nextInt();
                long j = (res[i - 1] + arr[i] - 1) / arr[i];
                while (res[i - 1] > j * arr[i])
                    j++;
                res[i] = j * arr[i];
            }
            ans.append(res[i]).append(" ");
        }
        ans.append('\n');
    }

    public void printAns() {
        fPrinter.println(ans);
    }
}

class FastPrinter {
    private final PrintWriter out;

    FastPrinter(OutputStream out) {
        this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));
    }
    public void println(Object o) {
        out.println(o);
    }

    public void close() {
        out.close();
    }
}

class FastReader {
    private static final int BUFFER_SIZE = 1 << 17;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer;
    private int bytesRead;

    public FastReader(InputStream in) {
        din = new DataInputStream(in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();

        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');

        if (neg)
            c = read();

        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }


}
