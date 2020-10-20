///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 568, NAME: ZABAWNE DODAWANIE PIOTRUSIA //
/// link: https://pl.spoj.com/problems/BFN1 ///////////
/// TIME RESULT FOR THIS SOLUTION = 0,09s /////////////
///////////////////////////////////////////////////////
package spoj;

import java.io.*;

public class ZabawneDodawaniePiotrusia {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb1;
        StringBuilder strb2;

        short t = Short.parseShort(br.readLine());

        for (short i = 0; i < t; i++) {
            int count = 0;
            int number = Integer.parseInt(br.readLine());

           do {
               strb1 = new StringBuilder();
               strb2  = new StringBuilder();
               strb1.append(number);
               strb2.append(strb1).reverse();
               count++;
               number = (Integer.parseInt(strb1.toString()) + Integer.parseInt(strb2.toString()));
           } while (!strb1.toString().equals(strb2.toString()));

            strb1.append(" " + --count).append("\n");
            out.write(strb1.toString().getBytes());
            out.flush();
        }

    }
}
