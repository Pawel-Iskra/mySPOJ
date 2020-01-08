///////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////
/// TASK ID = 506, NAME: FLAMASTER ////////////////
/// link: https://pl.spoj.com/problems/FLAMASTE ///
/// TIME RESULT FOR THIS SOLUTION = 0,07s ///////// 
/// SOURCE CODE LENGTH LIMIT = 2000B //////////////
///////////////////////////////////////////////////

package mySPOJ;

import java.io.*;

public class FLAMASTE_Flamaster {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new BufferedOutputStream(System.out);

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringBuilder strb = new StringBuilder();
            char[] input = br.readLine().toCharArray();
            int length = input.length;
            int j;
            for (j = 0; j < length - 2; j++) {
                strb.append(input[j]);
                if (input[j] == input[j + 1] && input[j + 1] == input[j + 2]) {
                    int k = j + 1;
                    int count = 1;
                    while (input[j] == input[k]) {
                        count++;
                        k++;
                        if (k == length) break;
                    }
                    strb.append(count);
                    j = j + count - 1;
                }
            }
            if (j == length - 2) strb.append(input[j]).append(input[j + 1]);
            else if (j == length - 1) strb.append(input[j]);

            strb.append("\n");
            out.write(strb.toString().getBytes());
            out.flush();
        }

    }
}

