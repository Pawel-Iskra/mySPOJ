///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 1240, NAME: WSPOŁLINIOWOŚĆ PUNKTÓW //////
/// link: https://pl.spoj.com/problems/JWSPLIN/ ///////
/// TIME RESULT FOR THIS SOLUTION = 0,07s /////////////
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
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }

    private static String getAnswerIfIsCollinear(int[] points) {
        int determinant = -1;
        determinant = points[0] * points[3] + points[2] * points[5]
                + points[4] * points[1] - points[2] * points[1]
                - points[0] * points[5] - points[4] * points[3];
        return determinant == 0 ? "TAK" : "NIE";
    }

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        OutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();

        int tests = rd.nextInt();
        for (int i = 0; i < tests; i++) {

            int[] points = new int[6];
            for (int j = 0; j < 6; j++) {
                points[j] = rd.nextInt();
            }
            strb.append(getAnswerIfIsCollinear(points)).append("\n");
        }
        out.write(strb.toString().getBytes());
        out.flush();
    }
}