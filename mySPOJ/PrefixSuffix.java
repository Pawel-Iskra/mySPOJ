package _01_EASY._03_Third_Fifty.Zad_137_Prefiks_sufiks;

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

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();

        int t = rd.nextInt();
        for (int i = 0; i < t; i++) {
            int n = rd.nextInt();
            int numbers[] = new int[n];
            long sufiks = 0;
            for (int j = 0; j < n; j++) {
                int x = rd.nextInt();
                numbers[j] = x;
                sufiks = sufiks + x;
            }
            long prefiks = 0;
            boolean flag = false;
            for (int j = 0; j < n - 1; j++) {
                int x = numbers[j];
                prefiks = prefiks + x;
                sufiks = sufiks - x;
                if (prefiks == sufiks) {
                    strb.append(++j).append("\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) strb.append(0).append("\n");
        }
        out.write(strb.toString().getBytes());
        out.flush();
    }
}
