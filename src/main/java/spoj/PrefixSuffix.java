/////////////////////////////////////////////////////////
/// NOTES: //////////////////////////////////////////////
/// TASK ID = 11059, NAME: Prefiks równoważący sufiks ///
/// link: https://pl.spoj.com/problems/MWP4_1E //////////
/// TIME RESULT FOR THIS SOLUTION = 0,21s ///////////////
/////////////////////////////////////////////////////////

package spoj;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class PrefixSuffix {

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

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        private int nextInt() throws IOException {
            int n = 0;
            byte c = read();
            while (c < 33) c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                n = n * 10 + c - 48;
            } while ((c = read()) > 47);
            if (neg) return -n;
            return n;
        }
    }

    private static int getPosition(int[] array, long suffix) {
        int position = 0;
        int amount = array.length;
        long prefix = 0;
        for (int j = 0; j < amount - 1; j++) {
            int x = array[j];
            prefix = prefix + x;
            suffix = suffix - x;
            if (prefix == suffix) {
                position = ++j;
                break;
            }
        }
        return position;
    }

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();

        int tests = rd.nextInt();
        for (int i = 0; i < tests; i++) {

            int amount = rd.nextInt();
            int[] numbers = new int[amount];
            long suffix = 0;
            for (int j = 0; j < amount; j++) {
                int x = rd.nextInt();
                numbers[j] = x;
                suffix = suffix + x;
            }
            int result = getPosition(numbers, suffix);
            strb.append(result).append("\n");
        }
        out.write(strb.toString().getBytes());
        out.flush();
    }
}