///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 568, NAME: ZABAWNE DODAWANIE PIOTRUSIA //
/// link: https://pl.spoj.com/problems/BFN1 ///////////
/// TIME RESULT FOR THIS SOLUTION = 0,10s /////////////
///////////////////////////////////////////////////////

package spoj;

import java.io.*;

public class ZabawneDodawaniePiotrusia {

    private static String getAnswer(int number) {
        StringBuilder strb1;
        StringBuilder strb2;
        int count = 0;
        do {
            strb1 = new StringBuilder();
            strb2 = new StringBuilder();
            strb1.append(number);
            strb2.append(strb1).reverse();
            count++;
            number = (Integer.parseInt(strb1.toString()) + Integer.parseInt(strb2.toString()));
        } while (!strb1.toString().equals(strb2.toString()));

        return strb1.append(" " + --count).toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();


        int tests = Integer.parseInt(br.readLine());
        for (int i = 0; i < tests; i++) {

            int number = Integer.parseInt(br.readLine());
            strb.append(getAnswer(number)).append("\n");
        }
        out.write(strb.toString().getBytes());
        out.flush();

    }
}