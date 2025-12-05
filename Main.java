package timus_task1313;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static void main(String[] args) {
        String inputFileName = "lr5/src/timus_task1880/input.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;

        try {
            BufferedReader bufferedReader =
                    oj ? new BufferedReader(new InputStreamReader(System.in)) :
                            new BufferedReader(new FileReader(inputFileName));

            String line = bufferedReader.readLine();
            if (line == null) return;
            int size = Integer.parseInt(line.trim());

            int[][] ints = new int[size][size];

            for (int i = 0; i < size; i++) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {

                    break;
                }
                String[] strings = readLine.trim().split("\\s+");
                for (int j = 0; j < size; j++) {
                    if (j < strings.length) {
                        ints[i][j] = Integer.parseInt(strings[j]);
                    } else {

                        ints[i][j] = 0;
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                for (int j = i; j >= 0; j--) {
                    System.out.print(ints[j][i - j] + " ");
                }
            }

            for (int i = 1; i < size; i++) {
                for (int j = size - 1; j >= i; j--) {
                    System.out.print(ints[j][size - j + i - 1] + " ");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}