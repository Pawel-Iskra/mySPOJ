////////////////////////////////////////////////////////
/// NOTES: /////////////////////////////////////////////
/// TASK ID = 9022, NAME: BAJTOCKIE ŚWIĘTO TRÓJKĄTA ////
/// link: https://pl.spoj.com/problems/BAJTST //////////
/// TIME RESULT FOR THIS SOLUTION = 0,06s //////////////
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
            do {
                num = num * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return num;
        }

        public double nextDouble() throws IOException {
            double num = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            do {
                num = num * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    num += (c - '0') / (div *= 10);
                }
            }
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

    private static double getTriangleArea(int sideA, int sideB, int sideC) {
        double area = 0;
        if (Math.abs(sideB - sideC) < sideA && sideA < (sideB + sideC)) {
            area = Math.sqrt((double) (sideA + sideB + sideC)
                    * (double) (sideA + sideB - sideC)
                    * (double) (sideA + sideC - sideB)
                    * (double) (sideB + sideC - sideA)) / 4;
        }
        return area;
    }

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();

        int tests = rd.nextInt();
        for (int i = 0; i < tests; i++) {
            double sum = 0;
            int people = rd.nextInt();
            double chalkUsage = rd.nextDouble() / 10;

            for (int j = 0; j < people; j++) {
                int sideA = rd.nextInt();
                int sideB = rd.nextInt();
                int sideC = rd.nextInt();

                sum = sum + chalkUsage * getTriangleArea(sideA, sideB, sideC);
            }

            long result = Math.round(sum);
            strb.append(result).append("\n");
        }
        out.write(strb.toString().getBytes());
        out.flush();
    }
}