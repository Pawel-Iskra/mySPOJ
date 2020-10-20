///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 1909, NAME: SUMY WIELOKROTNE ////////////
/// link: https://pl.spoj.com/problems/KC008 //////////
/// TIME RESULT FOR THIS SOLUTION = 0,08s /////////////
/// NOTE: BEST TIME IN JAVA RANKING SOLUTIONS /////////
/// USAGE: LOW LEVEL NUMBER READING ///////////////////
///////////////////////////////////////////////////////
package spoj;

import java.io.*;

public class SumyWielokrotne {

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
        StringBuilder strb = new StringBuilder();
        long allTotal = 0;

        int c;
        while (true) {

            long lineTotal = 0;
            c = rd.read();
            if (c == -1) break;

            while (c != '\n') {
                if (c == 32) c = rd.read();
                boolean neg = (c == 45);
                if (neg) c = rd.read();
                int num = 0;
                while (c >= 48 && c <= 57) {
                    num = num * 10 + c - 48;
                    c = rd.read();
                }
                if (neg) num = -num;
                lineTotal = lineTotal + num;
            }
            allTotal = allTotal + lineTotal;
            strb.append(lineTotal).append("\n");
        }
        strb.append(allTotal);
        out.write(strb.toString().getBytes());
        out.flush();
    }
}
