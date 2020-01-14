/////////////////////////////////////////////////////////
/// NOTES: //////////////////////////////////////////////
/// TASK ID = 1019, NAME: SYSTEMY POZYCYJNE /////////////
/// link: https://pl.spoj.com/problems/SYS //////////////
/// TIME RESULT FOR THIS SOLUTION = 0,54s ///////////////
/// USAGE: CONVERTING A NUMBER FROM DECIMAL SYSTEM TO ///
/// HEXADECIMAL AND ELEVENTH SYSTEM REPRESENTATION //////
/////////////////////////////////////////////////////////
package mySPOJ;

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
        StringBuilder strb1 = new StringBuilder();
        StringBuilder strb2 = new StringBuilder();

        int tests = rd.nextInt();
        for (int i = 0; i < tests; i++) {
            int num = rd.nextInt();
            int copy = num;
            while (copy != 0) {
                int rest = copy % 16;
                if (rest <= 9) strb1.append(rest);
                else {
                    switch (rest) {
                        case 10:
                            strb1.append('A');
                            break;
                        case 11:
                            strb1.append('B');
                            break;
                        case 12:
                            strb1.append('C');
                            break;
                        case 13:
                            strb1.append('D');
                            break;
                        case 14:
                            strb1.append('E');
                            break;
                        case 15:
                            strb1.append('F');
                            break;
                    } // end switch
                } // end else
                copy = copy / 16;
            } // end while
            strb1.reverse().append(" ");

            while (num != 0) {
                if (num % 11 <= 9) strb2.append(num % 11);
                else strb2.append('A');
                num = num / 11;
            }
            strb2.reverse();

            strb1.append(strb2);
            strb1.append("\n");
            out.write(strb1.toString().getBytes());
            out.flush();
            strb1.delete(0,strb1.length());
            strb2.delete(0,strb2.length());
        }


    }
}
