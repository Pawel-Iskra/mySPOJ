//////////////////////////////////////////////////////////
/// NOTES: ///////////////////////////////////////////////
/// TASK ID = 438, NAME: LICZBY PIERWSZE /////////////////
/// link: https://pl.spoj.com/problems/PRIME_T ///////////
/// TIME RESULT FOR THIS SOLUTION = 0,09s ////////////////
/// USAGE: DETERMINING IF THE NUMBER IS PRIME ////////////
/// BY USING - IN SOME WAY - SIEVE OF ERATOSTHENES ///////
//////////////////////////////////////////////////////////

package mySPOJ;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class LiczbyPierwsze {

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

      public int nextInt() throws IOException {
            int num = 0;
            byte c = read();
            while (c <= ' ') c = read();
            do {
                num = num * 10 + c - '0';
            } while ((c = read()) >= '0');
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
    
    private static boolean isPrime(int x) {
        if (x % 2 == 0) return x == 2;
        int sqrt = (int) Math.sqrt(x) + 1;
        for (int i = 3; i < sqrt; i = i + 2) if (x % i == 0) return false;
        return x > 1;
    }

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        StringBuilder strb = new StringBuilder();

       int n = rd.nextInt();
        for (int i = 0; i < n; i++) {
            if (isPrime(rd.nextInt())) strb.append("TAK\n");
            else strb.append("NIE\n");
        }

        OutputStream out = new BufferedOutputStream(System.out);
        out.write(strb.toString().getBytes());
        out.flush();
    }
}
