////////////////////////////////////////////////////////
/// NOTES: /////////////////////////////////////////////
/// TASK ID = 9022, NAME: BAJTOCKIE ŚWIĘTO TRÓJKĄTA ////
/// link: https://pl.spoj.com/problems/BAJTST //////////
/// TIME RESULT FOR THIS SOLUTION = 0,07s //////////////
/// NOTE: BEST TIME IN JAVA RANKING SOLUTIONS //////////
/// USAGE: HERON'S FORMULA /////////////////////////////
////////////////////////////////////////////////////////
package spoj;
import java.io.*;

public class BajtockieSwietoTrojkata {


    public static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        private Reader() {
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

        public double nextDouble() throws IOException {
            double num = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                num = num * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9')
                    num += (c - '0') / (div *= 10);
            }
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

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();

        int t = rd.nextInt();
        for (int i = 0; i < t; i++) {
            double sum = 0;
            int n = rd.nextInt();
            double k = rd.nextDouble() / 10;

            for (int j = 0; j < n; j++) {
                int a = rd.nextInt();
                int b = rd.nextInt();
                int c = rd.nextInt();
                if (Math.abs(b - c) < a && a < (b + c)) {
                    double area = Math.sqrt((double) (a + b + c)
                            * (double) (a + b - c)
                            * (double) (a + c - b)
                            * (double) (b + c - a)) / 4;
                    sum = sum + k * area;
                }
            }
            long result = Math.round(sum);
            strb.append(result);

            strb.append("\n");
            out.write(strb.toString().getBytes());
            out.flush();
            strb.delete(0, strb.length());
        }

    }
}
