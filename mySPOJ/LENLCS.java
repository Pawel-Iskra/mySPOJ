///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 498 /////////////////////////////////////
/// NAME: DŁUGOŚĆ NAJDŁUŻSZEGO WSPÓLNEGO PODCIĄGU /////
/// link: https://pl.spoj.com/problems/LENLCS/ ////////
/// TIME RESULT FOR THIS SOLUTION = 0,10s /////////////
/// USAGE: ALGORITHM DETERMINING LENGTH OF LONGEST ////
/// COMMON SUBSEQUENCE ////////////////////////////////
///////////////////////////////////////////////////////
package mySPOJ;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class LENLCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();
        int max = 0;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int len1 = Integer.parseInt(br.readLine());
            char[] word1 = br.readLine().toCharArray();

            int len2 = Integer.parseInt(br.readLine());
            char[] word2 = br.readLine().toCharArray();

            int[][] matrix = new int[len1 + 1][len2 + 1];

            for (int j = 0; j < len1; j++) {
                for (int k = 0; k < len2; k++) {

                    if (word1[j] == word2[k]) {
                        matrix[j + 1][k + 1] = 1 + matrix[j][k];
                    } else {
                        max = matrix[j + 1][k];
                        if (matrix[j][k + 1] > max) max = matrix[j][k + 1];
                        matrix[j + 1][k + 1] = max;
                    }
                }
            }
            strb.append(matrix[len1][len2]).append("\n");
        }
        out.write(strb.toString().getBytes());
        out.flush();
    }
}
