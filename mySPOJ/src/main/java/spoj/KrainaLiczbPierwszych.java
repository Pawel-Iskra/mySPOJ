///////////////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////////////
/// TASK ID = 569, NAME: PIOTRUŚ W KRAINIE LICZB PIERWSZYCH ///
/// link: https://pl.spoj.com/problems/BFN2/ //////////////////
/// TIME RESULT FOR THIS SOLUTION =    ////////////////////////
/// USAGE: MULTITHREADING, SIEVE OF ERATOSTHENES //////////////
///////////////////////////////////////////////////////////////

package spoj;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class KrainaLiczbPierwszych {

    private static class PrimeNumbersCounter implements Callable {
        private int start;
        private int end;

        public PrimeNumbersCounter(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public StringBuilder call() throws Exception {
            StringBuilder strb = new StringBuilder();
            if (start == 2) {
                strb.append(2).append("\n");
                start++;
            }
            if (start % 2 == 0) start++;
            for (int i = start; i <= end; i = i + 2) {
                if (isPrime(i)) {
                    strb.append(i).append("\n");
                }
            }
            return strb;
        }

        private boolean isPrime(int x) {
            int sqrt = (int) Math.sqrt(x) + 1;
            for (int i = 3; i < sqrt; i = i + 2) if (x % i == 0) return false;
            return true;
        }
    }


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
            while (c < 32) c = read();
            do {
                n = n * 10 + c - 48;
            } while ((c = read()) >= 48);
            return n;
        }
    }

    private static StringBuilder getResultIfLessThanOneHundred(int start, int end) {
        StringBuilder strb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) strb.append(i).append("\n");
        }
        return strb;
    }

    private static boolean isPrime(int x) {
        if (x % 2 == 0) return x == 2;
        int sqrt = (int) Math.sqrt(x) + 1;
        for (int i = 3; i < sqrt; i = i + 2) if (x % i == 0) return false;
        return true;
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Reader rd = new Reader();
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb;
        final int numOfThreads = 4;

        int tests = rd.nextInt();
        while (tests-- > 0) {
            strb = new StringBuilder();
            int start = rd.nextInt();
            int end = rd.nextInt();
            int diff = end - start;
            if (diff > 100) {
                int[] starts = new int[numOfThreads];
                int[] ends = new int[numOfThreads];
                diff = diff / numOfThreads;
                starts[0] = start;
                ends[0] = start + diff;
                for (int i = 1; i < numOfThreads; i++) {
                    starts[i] = ends[i - 1] + 1;
                    ends[i] = starts[i] + diff;
                }
                ends[numOfThreads - 1] = end;

                FutureTask<StringBuilder>[] futureTasks = new FutureTask[numOfThreads];
                for (int i = 0; i < numOfThreads; i++) {
                    futureTasks[i] = new FutureTask<StringBuilder>(new PrimeNumbersCounter(starts[i], ends[i]));
                    Thread thread = new Thread(futureTasks[i]);
                    thread.start();
                }

                for (int i = 0; i < numOfThreads; i++) {
                   strb.append(futureTasks[i].get());
                }
            } else {
                strb.append(getResultIfLessThanOneHundred(start, end));
            }
            out.write(strb.toString().getBytes());
            out.flush();
        }

    }
}
