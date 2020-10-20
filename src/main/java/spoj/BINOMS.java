///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 833, NAME: DWUMIANY /////////////////////
/// link: https://pl.spoj.com/problems/BINOMS /////////
/// TIME RESULT FOR THIS SOLUTION = 0,10s /////////////
/// USAGE: BINOMINAL COEFFICIENT - NEWTON SYMBOL //////
///////////////////////////////////////////////////////

package spoj;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BINOMS {

    private static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        private Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private int nextInt() throws IOException {
            int num = 0;
            byte c = read();
            while (c <= 32) c = read();
            do {
                num = num * 10 + c - 48;
            } while ((c = read()) >= 48 && c <= 57);
            return num;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }

    private static long getNewtonSymbol(int n, int k) {
        long result = 1;
        if ((n - k) > k) {
            k = n - k;
        }
        k++;

        for (int num = n, den = 1; num >= k; num--, den++) {
            result = result * num / den;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        OutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();

        int tests = rd.nextInt();
        for (int i = 0; i < tests; i++) {
            int n = rd.nextInt();
            int k = rd.nextInt();

            strb.append(getNewtonSymbol(n, k)).append("\n");
        }

        out.write(strb.toString().getBytes());
        out.flush();
    }
}