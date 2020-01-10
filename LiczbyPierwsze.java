//////////////////////////////////////////////////////////
/// NOTES: ///////////////////////////////////////////////
/// TASK ID = 438, NAME: LICZBY PIERWSZE /////////////////
/// link: https://pl.spoj.com/problems/PRIME_T ///////////
/// TIME RESULT FOR THIS SOLUTION = 0,15s ////////////////
/// USAGE: DETERMINING IF THE NUMBER IS PRIME ////////////
/// BY USING - IN SOME WAY - SIEVE OF ERATOSTHENES ///////
//////////////////////////////////////////////////////////

package mySPOJ;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class LiczbyPierwsze {

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
            int num = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                num = num * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -num;
            return num;
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

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        StringBuilder strb = new StringBuilder();

        int n = rd.nextInt();
        for (int i = 0; i < n; i++) {
            int x = rd.nextInt();

            boolean flag = false;
            int val = (int) Math.sqrt(x) + 1;

            for (int j = 3; j < val; j = j + 2) {
                if (x % j == 0) {
                    strb.append("NIE").append("\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                if (x == 1) strb.append("NIE").append("\n");
                else if (x == 2) strb.append("TAK").append("\n");
                else if (x % 2 == 0) strb.append("NIE").append("\n");
                else strb.append("TAK").append("\n");
            }
        }

        OutputStream out = new BufferedOutputStream(System.out);
        out.write(strb.toString().getBytes());
        out.flush();
    }
}
