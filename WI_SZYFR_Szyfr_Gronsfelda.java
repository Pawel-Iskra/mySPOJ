package mySPOJ;

import java.io.*;
/////////////////////////////////////////////
/// THIS SOLUTION GETS RESULT = 100% ////////
/// TIME RESULT FOR THIS SOLUTION = 0,70s ///
/////////////////////////////////////////////
public class WI_SZYFR_Szyfr_Gronsfelda {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new BufferedOutputStream(System.out);

        String line;
        while ((line = br.readLine()) != null) {
            String action = line;
            char[] key = String.valueOf(Integer.parseInt(br.readLine())).toCharArray();
            char text[] = br.readLine().toCharArray();

            int k;
            StringBuilder strb = new StringBuilder();
            int textSize = text.length;
            int keySize = key.length;
            switch (action.charAt(0)) {
                case 'S':
                    for (int i = 0; i < textSize; i++) {
                        k = i % keySize;
                        if (text[i] + key[k] > 138) strb.append((char) (text[i] + key[k] - 74));
                        else strb.append((char) (text[i] + key[k] - 48));
                    }
                    break;
                case 'D':
                    for (int i = 0; i < textSize; i++) {
                        k = i % keySize;
                        if (text[i] - key[k] < 17) strb.append((char) (text[i] - key[k] + 74));
                        else strb.append((char) (text[i] - key[k] + 48));
                    }
                    break;
            }

            strb.append("\n");
            out.write(strb.toString().getBytes());
            out.flush();
        }

    }
}
