///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 655, NAME: Gray code ////////////////////
/// link: https://pl.spoj.com/problems/PP0505D ////////
/// TIME RESULT FOR THIS SOLUTION = 0,11s /////////////
/// USAGE: GENERATING ALL POSSIBLE BINARY STRINGS /////
/// OF A GIVEN LENGTH IN THE ORDER OF GRAY CODE ///////
///////////////////////////////////////////////////////

package spoj;

import java.io.*;

public class GrayCode {

    private static byte[][] getGrayCodeForNextLevel(byte[][] base) {
        int lineBase = base.length;
        int levBase = base[0].length;

        int lineRes = 2 * lineBase;
        int levRes = levBase + 1;
        byte[][] res = new byte[lineRes][levRes];

        for (int i = 0; i < lineBase; i++) {
            for (int j = 0; j < levBase; j++) {
                res[i][j + 1] = base[i][j];
            }
        }
        int factor = 1;
        int start = lineRes / 2;
        for (int i = start; i < lineRes; i++) {
            for (int j = 1; j < levRes; j++) {
                res[i][j] = res[start - factor][j];
            }
            factor++;
        }
        for (int i = start; i < lineRes; i++) {
            res[i][0] = 1;
        }

        return res;
    }

    private static String getResultToPrintOut(int level) {
        StringBuilder strb = new StringBuilder();
        byte[][] base = new byte[2][1];
        base[0][0] = 0;
        base[1][0] = 1;
        byte[][] result = base;

        for (int j = 1; j < level; j++) {
            result = getGrayCodeForNextLevel(result);
        }

        for (int j = 0; j < result.length; j++) {
            for (int k = 0; k < result[0].length; k++) {
                strb.append(result[j][k]);
            }
            strb.append("\n");
        }
        return strb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();

        int tests = Integer.parseInt(rd.readLine());
        for (int i = 0; i < tests; i++) {

            int level = Integer.parseInt(rd.readLine());
            strb.append(getResultToPrintOut(level)).append("\n");
        }
        out.write(strb.toString().getBytes());
        out.flush();
    }
}