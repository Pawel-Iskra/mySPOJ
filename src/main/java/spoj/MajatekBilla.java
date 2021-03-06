////////////////////////////////////////////////////////
/// NOTES: /////////////////////////////////////////////
/// TASK ID = 5853, NAME: MAJĄTEK BILLA ////////////////
/// link: https://pl.spoj.com/problems/MWP2_2B /////////
/// TIME RESULT FOR THIS SOLUTION = 0,21s //////////////
/// NOTE: BEST TIME IN JAVA RANKING SOLUTIONS //////////
/// USAGE: FAST MODULAR EXPONENTIATION /////////////////
////////////////////////////////////////////////////////
package spoj;

import java.io.*;

public class MajatekBilla {

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

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }

    private static int getModulo(int base, int exp, int modulo) {
        int result = 1;
        int rest = base % modulo;

        for (int i = 1; i <= exp; i = i << 1) {
            rest = rest % modulo;
            if ((exp & i) != 0) {
                result = result * rest;
                result = result % modulo;
            }
            rest = rest * rest;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();

        int base = rd.nextInt();
        int exp = rd.nextInt();
        int modulo = rd.nextInt();
        do {
            int result = getModulo(base, exp, modulo);
            strb.append(result).append("\n");

        } while ((base = rd.nextInt()) != 0 && (exp = rd.nextInt()) != 0 && (modulo = rd.nextInt()) != 0);

        out.write(strb.toString().getBytes());
        out.flush();
    }
}