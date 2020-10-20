///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 663, NAME: SORT 1 ///////////////////////
/// link: https://pl.spoj.com/problems/PP0506A ////////
/// TIME RESULT FOR THIS SOLUTION = 0,08s /////////////
/// USAGE: INSERTION SORT /////////////////////////////
///////////////////////////////////////////////////////

package spoj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Sort1 {

    private static class Point {
        String name;
        double dist;

        public Point(String name, double distance) {
            this.name = name;
            this.dist = distance;
        }
    }

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

            List<Point> points = new ArrayList<>();
            StringBuilder strb;
            int n = rd.nextInt();
            for (short j = 0; j < n; j++) {

                strb = new StringBuilder();
                int c;
                while ((c = rd.read()) != 32) strb.append((char) c);

                int x = rd.nextInt();
                int y = rd.nextInt();
                double dist = Math.sqrt(x * x + y * y);

                strb.append(" ").append(x).append(" ").append(y);
                Point point = new Point(strb.toString(), dist);
                points.add(point);
            }

            int size = points.size();
            for (int j = 1; j < size; j++) {
                Point temp = points.get(j);
                int k = j - 1;
                while (k >= 0 && temp.dist < points.get(k).dist) {
                    points.set((k + 1), points.get(k));
                    k--;
                }
                points.set(k + 1, temp);
            }

            strb = new StringBuilder();
            for (short j = 0; j < n; j++) strb.append(points.get(j).name).append("\n");

            out.write(strb.toString().getBytes());
            out.flush();
        }


    }
}
