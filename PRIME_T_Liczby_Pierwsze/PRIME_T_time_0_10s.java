package mySPOJ.PRIME_T_Liczby_Pierwsze;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;

/////////////////////////////////////////////
/// TIME RESULT FOR THIS SOLUTION = 0,10s ///
/////////////////////////////////////////////
public class PRIME_T_time_0_10s {

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
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                num = num * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -num;
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

            if (x == 2 || x == 3 || x == 5 || x == 7 || x == 11 || x == 13
                    || x == 17 || x == 19 || x == 23 || x == 29 || x == 31 || x == 37
                    || x == 41 || x == 43 || x == 47 || x == 53 || x == 59 || x == 61
                    || x == 67 || x == 71 || x == 73 || x == 79 || x == 83 || x == 89
                    || x == 97) {
                strb.append("TAK").append("\n");
            } else if (x == 1 || x % 2 == 0 || x % 3 == 0 || x % 5 == 0 || x % 7 == 0 || x % 11 == 0
                    || x % 13 == 0 || x % 17 == 0 || x % 19 == 0 || x % 23 == 0 || x % 29 == 0
                    || x % 31 == 0 || x % 37 == 0 || x % 41 == 0 || x % 43 == 0 || x % 47 == 0
                    || x % 53 == 0 || x % 59 == 0 || x % 61 == 0 || x % 67 == 0 || x % 71 == 0
                    || x % 73 == 0 || x % 79 == 0 || x % 83 == 0 || x % 89 == 0 || x % 97 == 0) {
                strb.append("NIE").append("\n");
            } else strb.append("TAK").append("\n");



        } // end for 0->n

        OutputStream out = new BufferedOutputStream(System.out);
        out.write(strb.toString().getBytes());
        out.flush();
    }
}
