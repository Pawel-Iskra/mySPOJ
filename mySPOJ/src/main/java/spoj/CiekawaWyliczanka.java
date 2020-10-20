///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 751 /////////////////////////////////////
/// NAME: CIEKAWA WYLICZANKA //////////////////////////
/// link: https://pl.spoj.com/problems/ETI06F2 ////////
/// TIME RESULT FOR THIS SOLUTION = 0,91s /////////////
///////////////////////////////////////////////////////
package spoj;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;


public class CiekawaWyliczanka {

    static class Reader {
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

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        StringBuilder strb = new StringBuilder();
        BufferedOutputStream out = new BufferedOutputStream(System.out);

        int n = rd.nextInt();

        String binaryN = Integer.toBinaryString(n);
        int length = binaryN.length();
        if (binaryN.contains("0")) {
            length--;
            for (int i = 0; i < length; i++) strb.append(5);
            int baseNr = 1;
            for (int i = 0; i < length; i++) baseNr = baseNr * 2;
            baseNr--;
            int diff = n - baseNr;
            char[] baseChars = strb.toString().toCharArray();
            char[] diffChars = Integer.toBinaryString(diff).toCharArray();
            int baseLen = baseChars.length;
            int diffLen = diffChars.length;
            for (int i = 0; i < diffLen; i++)
                baseChars[baseLen - i - 1] = (char) (baseChars[baseLen - i - 1] + diffChars[diffLen - i - 1] - 48);
            strb.delete(0,strb.length());
            strb.append(baseChars);
        } else
            for (int i = 0; i < length; i++) strb.append(5);

        out.write(strb.toString().getBytes());
        out.flush();
    }
}
