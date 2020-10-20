/////////////////////////////////////////////////////////
/// NOTES: //////////////////////////////////////////////
/// TASK ID = 1019, NAME: SYSTEMY POZYCYJNE /////////////
/// link: https://pl.spoj.com/problems/SYS //////////////
/// TIME RESULT FOR THIS SOLUTION = 0,34s ///////////////
/// USAGE: CONVERTING A NUMBER FROM DECIMAL SYSTEM TO ///
/// HEXADECIMAL AND ELEVENTH SYSTEM REPRESENTATION //////
/////////////////////////////////////////////////////////
package spoj;

import java.io.*;

public class SystemyPozycyjne {

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

    private static String getHexadecimal(int number) {
        StringBuilder strb = new StringBuilder();
        while (number != 0) {
            int rest = number % 16;
            if (rest <= 9) {
                strb.append(rest);
            } else {
                switch (rest) {
                    case 10:
                        strb.append('A');
                        break;
                    case 11:
                        strb.append('B');
                        break;
                    case 12:
                        strb.append('C');
                        break;
                    case 13:
                        strb.append('D');
                        break;
                    case 14:
                        strb.append('E');
                        break;
                    case 15:
                        strb.append('F');
                        break;
                }
            }
            number = number / 16;
        }
        strb.reverse();
        return strb.toString();
    }

    private static String getEleventhSystem(int number) {
        StringBuilder strb = new StringBuilder();
        while (number != 0) {
            if (number % 11 <= 9) strb.append(number % 11);
            else strb.append('A');

            number = number / 11;
        }
        strb.reverse();
        return strb.toString();
    }

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        OutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();

        int tests = rd.nextInt();
        for (int i = 0; i < tests; i++) {

            int number = rd.nextInt();
            String hexadecimal = getHexadecimal(number);
            String eleventhSystem = getEleventhSystem(number);
            strb.append(hexadecimal).append(" ").append(eleventhSystem).append("\n");
        }

        out.write(strb.toString().getBytes());
        out.flush();
    }
}