////////////////////////////////////////////////////////
/// NOTES: /////////////////////////////////////////////
/// TASK ID = 5927, NAME: TRÓJKĄT PASCALA //////////////
/// link: https://pl.spoj.com/problems/TROJPASC ////////
/// TIME RESULT FOR THIS SOLUTION = 0,13s //////////////
////////////////////////////////////////////////////////

package spoj;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;

public class PascalTriangle {

    private static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int x = 0;
            byte c = read();
            while (c <= ' ') c = read();
            do {
                x = x * 10 + c - '0';
            } while ((c = read()) >= '0');
            return x;
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

    private static String getNewtonSymbol(int n, int k) {
        BigInteger result = new BigInteger("1");
        if (k == 0) return result.toString();

        if ((n - k) > k) {
            k = n - k;
        }
        for (int numerator = n, denominator = 1; numerator > k; numerator--, denominator++) {
            result = result
                    .multiply(new BigInteger(String.valueOf(numerator)))
                    .divide(new BigInteger(String.valueOf(denominator)));
        }
        return result.toString();
    }

    private static String getLineOfPascalTriangle(int lineNumber) {
        StringBuilder strb = new StringBuilder();

        for (int i = 0; i <= lineNumber; i++) {
            strb.append(getNewtonSymbol(lineNumber, i)).append(" ");
        }
        return strb.toString();
    }

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();

        int tests = rd.nextInt();
        while (tests-- > 0) {
            int lineNumber = rd.nextInt();
            strb.append(getLineOfPascalTriangle(lineNumber)).append("\n");
        }

        out.write(strb.toString().getBytes());
        out.flush();
    }
}