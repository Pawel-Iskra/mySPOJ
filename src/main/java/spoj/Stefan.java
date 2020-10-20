///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 1299, NAME: STEFAN //////////////////////
/// link: https://pl.spoj.com/problems/FZI_STEF ///////
/// TIME RESULT FOR THIS SOLUTION =  //////////////////
/// USAGE: KADANE'S ALGORITHM /////////////////////////
///////////////////////////////////////////////////////

package spoj;

import java.io.*;

public class Stefan {
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
        StringBuilder strb = new StringBuilder();

        int n = rd.nextInt();
        int inst[] = new int[n];

        for (int i = 0; i < n; i++) inst[i] = rd.nextInt();

        long maxL = 0;
        long maxG = 0;
        for (int i = 0; i < n; i++) {
            if (inst[i] > (inst[i] + maxL)) maxL = inst[i];
            else maxL = inst[i] + maxL;
            if (maxL > maxG) maxG = maxL;
        }

        strb.append(maxG);
        out.write(strb.toString().getBytes());
        out.flush();
    }
}
