package mySPOJ.PRIME_T_Liczby_Pierwsze;

import java.io.*;

/////////////////////////////////////////////
/// TIME RESULT FOR THIS SOLUTION = 0,16s ///
/////////////////////////////////////////////
public class PRIME_T_time_0_16s {

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

        int[] pn = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

        int n = rd.nextInt();
        for (int i = 0; i < n; i++) {
            int x = rd.nextInt();

            boolean flag = false;

            for (short j = 0; j < 25; j++) {
                if (x == pn[j]) {
                    strb.append("TAK").append("\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                for (short j = 0; j < 25; j++) {
                    if (x % pn[j] == 0) {
                        strb.append("NIE").append("\n");
                        flag = true;
                        break;
                    }
                } // end for pn[]
            }
            if (!flag) {
                if (x == 1) strb.append("NIE").append("\n");
                else strb.append("TAK").append("\n");
            }
        }

        OutputStream out = new BufferedOutputStream(System.out);
        out.write(strb.toString().getBytes());
        out.flush();
    }
}
