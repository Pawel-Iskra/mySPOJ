///////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////
/// TASK ID = 506, NAME: FLAMASTER ////////////////
/// link: https://pl.spoj.com/problems/FLAMASTE ///
/// TIME RESULT FOR THIS SOLUTION = 0,06s /////////
/// SOURCE CODE LENGTH LIMIT = 2000B //////////////
///////////////////////////////////////////////////
package spoj;

import java.io.*;

public class Flamaster {

    private static String getShortenedString(String inputString) {
        StringBuilder strb = new StringBuilder();
        char[] string = inputString.toCharArray();
        int length = string.length;
        int j;
        for (j = 0; j < length - 2; j++) {
            strb.append(string[j]);
            if (string[j] == string[j + 1] && string[j + 1] == string[j + 2]) {
                int k = j + 1;
                int count = 1;
                while (string[j] == string[k]) {
                    count++;
                    k++;
                    if (k == length) break;
                }
                strb.append(count);
                j = j + count - 1;
            }
        }
        if (j == length - 2) {
            strb.append(string[j]).append(string[j + 1]);
        } else if (j == length - 1) {
            strb.append(string[j]);
        }

        return strb.toString();
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();

        int tests = Integer.parseInt(br.readLine());
        for (int i = 0; i < tests; i++) {
            String input = br.readLine();
            strb.append(getShortenedString(input)).append("\n");
        }
        out.write(strb.toString().getBytes());
        out.flush();
    }
}