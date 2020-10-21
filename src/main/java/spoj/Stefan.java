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
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }

    private static long getMaximumSubarraySum(int[] numbers) {
        int amount = numbers.length;
        long maxLocal = 0;
        long maxGlobal = 0;
        for (int i = 0; i < amount; i++) {
            if (numbers[i] > (numbers[i] + maxLocal)) maxLocal = numbers[i];
            else maxLocal = numbers[i] + maxLocal;
            if (maxLocal > maxGlobal) maxGlobal = maxLocal;
        }
        return maxGlobal;
    }

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        OutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();

        int amount = rd.nextInt();
        int[] numbers = new int[amount];
        for (int i = 0; i < amount; i++) {
            numbers[i] = rd.nextInt();
        }
        long result = getMaximumSubarraySum(numbers);

        strb.append(result);
        out.write(strb.toString().getBytes());
        out.flush();
    }
}