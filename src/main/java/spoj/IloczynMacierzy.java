///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 1940, NAME: ILOCZYN MACIERZY ////////////
/// link: https://pl.spoj.com/problems/KC014 //////////
/// TIME RESULT FOR THIS SOLUTION = 0,50s /////////////
///////////////////////////////////////////////////////

package spoj;

import java.io.*;

public class IloczynMacierzy {

    private static int[][] getMatrixProduct(String elementsOfFirstMatrix, String elementsOfSecondMatrix, int size) {
        String[] firstMatrixElements = elementsOfFirstMatrix.split(" ");
        String[] secondMatrixElements = elementsOfSecondMatrix.split(" ");
        int[][] matrix1 = new int[size][size];
        int[][] matrix2 = new int[size][size];
        int[][] matrixOut = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix1[i][j] = Integer.parseInt(firstMatrixElements[(j + i * size)]);
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix2[i][j] = Integer.parseInt(secondMatrixElements[(j + i * size)]);
            }
        }

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

    private static String getResultToPrintOut(String elementsOfFirstMatrix, String elementsOfSecondMatrix, int size) {
        StringBuilder strb = new StringBuilder();
        int[][] matrixOut = getMatrixProduct(elementsOfFirstMatrix, elementsOfSecondMatrix, size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                strb.append(matrixOut[i][j]).append(" ");
            }
        }
        return strb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();

        String matrixSize = rd.readLine();
        while (matrixSize != null) {
            String elementsOfFirstMatrix = rd.readLine().trim();
            String elementsOfSecondMatrix = rd.readLine().trim();
            int size = Integer.parseInt(matrixSize.trim());

            strb.append(getResultToPrintOut(elementsOfFirstMatrix, elementsOfSecondMatrix, size)).append("\n");
            matrixSize = rd.readLine();
        }

        out.write(strb.toString().getBytes());
        out.flush();
    }
}
