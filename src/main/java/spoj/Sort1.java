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
        private String name;
        private double dist;

        public Point(String name, double distance) {
            this.name = name;
            this.dist = distance;
        }

        public String getName() {
            return name;
        }

        public double getDist() {
            return dist;
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
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        OutputStream out = new BufferedOutputStream(System.out);

        int tests = rd.nextInt();
        for (int i = 0; i < tests; i++) {

            List<Point> points = new ArrayList<>();
            StringBuilder strb;
            int amount = rd.nextInt();
            for (short j = 0; j < amount; j++) {

                strb = new StringBuilder();
                int c;
                while ((c = rd.read()) != 32) {
                    strb.append((char) c);
                }

                int x = rd.nextInt();
                int y = rd.nextInt();
                double dist = Math.sqrt(x * x + y * y);

                String pointName = strb.append(" " + x + " " + y).toString();
                Point point = new Point(pointName, dist);
                points.add(point);
            }

            int size = points.size();
            for (int j = 1; j < size; j++) {
                Point temp = points.get(j);
                double tempDist = temp.getDist();
                int k = j - 1;
                while (k >= 0 && tempDist < points.get(k).getDist()) {
                    points.set((k + 1), points.get(k));
                    k--;
                }
                points.set(k + 1, temp);
            }

            strb = new StringBuilder();
            for (int j = 0; j < amount; j++) {
                strb.append(points.get(j).getName()).append("\n");
            }
            out.write(strb.toString().getBytes());
            out.flush();
        }

    }
}