///////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////
/// TASK ID = 4840, NAME: SZYFR GRONSFELDA ////////
/// link: https://pl.spoj.com/problems/WI_SZYFR ///
/// THIS SOLUTION GETS RESULT = 100% //////////////
/// TIME RESULT FOR THIS SOLUTION = 0,70s /////////
/// USAGE: GRONSFELD CIPHER ///////////////////////
///////////////////////////////////////////////////
package spoj;

import java.io.*;

public class SzyfrGronsfelda {

    private static String getText(String inputText, String inputKey, char command) {
        StringBuilder strb = new StringBuilder();
        char[] inText = inputText.toCharArray();
        char[] inKey = inputKey.toCharArray();

        int textSize = inText.length;
        int keySize = inKey.length;
        int k;
        switch (command) {
            case 'S':
                for (int i = 0; i < textSize; i++) {
                    k = i % keySize;
                    if (inText[i] + inKey[k] > 138) strb.append((char) (inText[i] + inKey[k] - 74));
                    else strb.append((char) (inText[i] + inKey[k] - 48));
                }
                break;
            case 'D':
                for (int i = 0; i < textSize; i++) {
                    k = i % keySize;
                    if (inText[i] - inKey[k] < 17) strb.append((char) (inText[i] - inKey[k] + 74));
                    else strb.append((char) (inText[i] - inKey[k] + 48));
                }
                break;
        }
        return strb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new BufferedOutputStream(System.out);
        StringBuilder strb = new StringBuilder();

        String action;
        while ((action = br.readLine()) != null) {
            String key = String.valueOf(Integer.parseInt(br.readLine()));
            String inputText = br.readLine();

            String outputText = getText(inputText, key, action.charAt(0));
            strb.append(outputText).append("\n");
        }
        out.write(strb.toString().getBytes());
        out.flush();
    }
}