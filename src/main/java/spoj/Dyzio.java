///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 520, NAME: DYZIO ////////////////////////
/// link: https://pl.spoj.com/problems/DYZIO2 /////////
/// TIME RESULT FOR THIS SOLUTION = 0,30s /////////////
/// USAGE: SIEVE OF ERATOSTHENES //////////////////////
///////////////////////////////////////////////////////

package spoj;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class Dyzio {

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
            while (c <= 32) c = read();
            do {
                num = num * 10 + c - 48;
            } while ((c = read()) >= 48 && c <= 57);
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

    private static boolean isPrime(int x) {
        if (x % 2 == 0) return x == 2;
        int sqrt = (int) Math.sqrt(x) + 1;
        for (int i = 3; i < sqrt; i++) if (x % i == 0) return false;
        return x > 1;
    }

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();
        int[] numberOfPrimes = new int[1000001];

        int counter = 0;
        for (int i = 0; i < 1000001; i++) {
            if (isPrime(i)) numberOfPrimes[i] = ++counter;
            else numberOfPrimes[i] = counter;
        }

        int tests = rd.nextInt();
        for (int i = 0; i < tests; i++) {
            int lowerLimit = rd.nextInt();
            int upperLimit = rd.nextInt();
            strb.append(numberOfPrimes[upperLimit] - numberOfPrimes[lowerLimit-1]).append("\n");
        }
        out.write(strb.toString().getBytes());
        out.flush();
    }
}