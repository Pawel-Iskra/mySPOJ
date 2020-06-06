///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 747, NAME: NWW2 /////////////////////////
/// link: https://pl.spoj.com/problems/NWW ////////////
/// TIME RESULT FOR THIS SOLUTION = 0,10s /////////////
/// USAGE: LEAST COMMON MULTIPLE METHOD ///////////////
/// THAT USES EUCLIDEAN ALGORITHM TO RECEIVE //////////
/// GREATEST COMMON DIVISOR ///////////////////////////
///////////////////////////////////////////////////////
package mySPOJ;

import java.io.*;

public class NWW2 {

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

        public long nextLong() throws IOException {
            long num = 0;
            byte c = read();
            while (c <= 32) c = read();
            boolean neg = (c == 45);
            if (neg) c = read();
            do {
                num = num * 10 + c - 48;
            } while ((c = read()) >= 48 && c <= 57);
            if (neg) return -num;
            return num;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)fillBuffer();
            return buffer[bufferPointer++];
        }
    }

    private static long getLCM(long a, long b) {
        long small = 0, big = 0, rest = 0;
        if (a > b) {
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }
        while ((rest = Long.remainderUnsigned(big, small)) != 0) {
            big = small;
            small = rest;
        }
        return (a / small * b);
    }

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        BufferedOutputStream out = new BufferedOutputStream(System.out);

        long t = rd.nextLong();
        for (int i = 0; i < t; i++) {

            long res = 1;
            long amount = rd.nextLong();
            for (int j = 0; j < amount; j++) {
                long num = rd.nextLong();
                res = getLCM(num, res);
            }

            StringBuilder strb = new StringBuilder(String.valueOf(Long.toUnsignedString(res)));
            strb.append("\n");
            out.write(strb.toString().getBytes());
            out.flush();
        }

    }
}
