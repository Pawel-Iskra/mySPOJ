///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 663, NAME: SORT 1 ///////////////////////
/// link: https://pl.spoj.com/problems/PP0506A ////////
/// TIME RESULT FOR THIS SOLUTION = 0,09s /////////////
/// USAGE: INSERTION SORT /////////////////////////////
///////////////////////////////////////////////////////

package spoj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Sort1 {

    private static class Point {
        private String name;
        private double dist;

        public Point(String name, double distance) {
            this.name = name;
            this.dist = distance;
        }

        public String getName() {
            return name;
        }

        public double getDist() {
            return dist;
        }
    }

    private static String getSortedPointsToPrintOust(String[] input) {
        StringBuilder strb;
        int amount = input.length;
        Point[] points = new Point[amount];
        for (int i = 0; i < amount; i++) {
            String pointName = input[i];
            String[] pointData = input[i].split(" ");
            int coordX = Integer.parseInt(pointData[1]);
            int coordY = Integer.parseInt(pointData[2]);
            double distance = Math.sqrt(coordX * coordX + coordY * coordY);
            points[i] = new Point(pointName, distance);
        }

        for (int j = 1; j < amount; j++) {
            Point temp = points[j];
            double tempDist = temp.getDist();
            int k = j - 1;
            while (k >= 0 && tempDist < points[k].getDist()) {
                points[(k + 1)] = points[k];
                k--;
            }
            points[k + 1] = temp;
        }

        strb = new StringBuilder();
        for (int j = 0; j < amount; j++) {
            strb.append(points[j].getName()).append("\n");
        }
        return strb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb;

        int tests = Integer.parseInt(rd.readLine());
        for (int i = 0; i < tests; i++) {

            int amount = Integer.parseInt(rd.readLine().trim());
            String[] input = new String[amount];
            for (int j = 0; j < amount; j++) {
                input[j] = rd.readLine();
            }

            strb = new StringBuilder();
            strb.append(getSortedPointsToPrintOust(input)).append("\n");
            out.write(strb.toString().getBytes());
            out.flush();
            rd.readLine();
        }

    }
}