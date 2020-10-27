///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 1940, NAME: ILOCZYN MACIERZY ////////////
/// link: https://pl.spoj.com/problems/KC014 //////////
/// TIME RESULT FOR THIS SOLUTION = 0,50s /////////////
///////////////////////////////////////////////////////

package spoj;

import java.io.*;

public class IloczynMacierzy {

    private static int[][] getMatrixProduct(int[][] matrix1, int[][] matrix2, int size) {
        int[][] matrixOut = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                int current = 0;
                for (int k = 0; k < size; k++) {
                    current = current + matrix1[i][k] * matrix2[k][j];
                }

                matrixOut[i][j] = current;
            }
        }
        return matrixOut;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();

        String lineWithMatrixSize = rd.readLine();
        while (lineWithMatrixSize != null) {
            String[] lineWithFirstMatrixElements = rd.readLine().trim().split(" ");
            String[] lineWithSecondMatrixElements = rd.readLine().trim().split(" ");

            int size = Integer.parseInt(lineWithMatrixSize.trim());
            int[][] matrix1 = new int[size][size];
            int[][] matrix2 = new int[size][size];
            int[][] matrixOut;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix1[i][j] = Integer.parseInt(lineWithFirstMatrixElements[(j + i * size)]);
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix2[i][j] = Integer.parseInt(lineWithSecondMatrixElements[(j + i * size)]);
                }
            }

            matrixOut = getMatrixProduct(matrix1, matrix2, size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    strb.append(matrixOut[i][j]).append(" ");
                }
            }
            strb.append("\n");
            lineWithMatrixSize = rd.readLine();
        }

        out.write(strb.toString().getBytes());
        out.flush();
    }
}
