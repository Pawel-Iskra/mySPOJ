///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 1432, NAME: SZYFFROWANIE 2 //////////////
/// link: https://pl.spoj.com/problems/JSZYFR2 ////////
/// TIME RESULT FOR THIS SOLUTION = 0,12s /////////////
///////////////////////////////////////////////////////

package SPOJ;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class Szyfrowanie2 {
    private static class Reader {
        final private int BUFFER_SIZE = 1 << 32;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int n = 0;
            byte c = read();
            while (c <= ' ') c = read();
            do {
                n = n * 10 + c - '0';
            } while ((c = read()) >= '0');
            return n;
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
        int primes[] = {127, 131, 137, 139, 149};

        int tests = rd.nextInt();
        while (tests-- > 0) {
            int numbers = rd.nextInt();
            int nums[] = new int[numbers];
            for (int i = 0; i < numbers; i++) nums[i] = rd.nextInt();

            int flag = 0;
            int key = 0;
            for (int i = 0; i < 5; i++) {
                int prime = primes[i];
                int count = 0;
                for (int j = 0; j < numbers; j++) {
                    int value = nums[j] % prime;
                    if (value >= 65 && value <= 90) count++;
                    else break;
                }
                if (count == numbers) {
                    flag++;
                    if (flag == 2) break;
                    key = prime;
                }
            }
            if (flag != 1) strb.append("NIECZYTELNE");
            else {
                strb.append(key).append(" ");
                for (int i = 0; i < numbers; i++) strb.append((char) (nums[i] % key));
            }
            strb.append("\n");
        }
        out.write(strb.toString().getBytes());
        out.flush();
    }
}
