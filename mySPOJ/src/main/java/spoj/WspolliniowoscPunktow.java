///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 1240, NAME: WSPOŁLINIOWOŚĆ PUNKTÓW //////
/// link: https://pl.spoj.com/problems/JWSPLIN/ ///////
/// TIME RESULT FOR THIS SOLUTION = 0,06s /////////////
/// USAGE: DETERMINANT OF SQUARE MATRIX ///////////////
///////////////////////////////////////////////////////
package spoj;

import java.io.*;

public class WspolliniowoscPunktow {

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
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
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
        OutputStream out = new BufferedOutputStream(System.out);

        int t = rd.nextInt();
        for (int i = 0; i < t; i++) {

            int[] num = new int[6];
            for (int j = 0; j < 6; j++) num[j] = rd.nextInt();

            int det = num[0] * num[3] + num[2] * num[5] + num[4] * num[1] - num[2] * num[1] - num[0] * num[5] - num[4] * num[3];

            StringBuilder strb = new StringBuilder();
            if (det == 0) strb.append("TAK").append("\n");
            else strb.append("NIE").append("\n");

            out.write(strb.toString().getBytes());
            out.flush();
        }

    }
}
