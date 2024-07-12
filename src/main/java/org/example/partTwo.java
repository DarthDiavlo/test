package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class partTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputOne = br.readLine().split(" ");
        int[] one = new int[inputOne.length];
        for (int i = 0; i < inputOne.length; i++) {
            one[i] = Integer.parseInt(inputOne[i]);
        }
        String[] inputPrices = br.readLine().split(" ");
        int[] prices = new int[inputPrices.length];
        for (int i = 0; i < inputPrices.length; i++) {
            prices[i] = Integer.parseInt(inputPrices[i]);
        }
        int money = 0;
        int[] counts = new int[one[0]];
        int reserve = 0;
        int[] buf = new int[one[1]];
        for (int j = 0; j < one[1]; j++) {
            buf[j] = prices[j];
        }
        int min = Arrays.stream(buf).min().getAsInt();
        for (int i = 0; i < one[0]; i++) {
            if (i <= prices.length - one[1]) {
                min = Math.min(min, prices[i + one[1] - 1]);
            }
            if (prices[i] > min && (reserve > 0)) {
                counts[i] = 0;
            } else {
                if (prices[i] == min) {
                    counts[i] = one[1];
                    reserve += one[1];
                    money += prices[i] * one[1];
                } else {
                    counts[i] = 1;
                    reserve += 1;
                    money += prices[i];
                }
            }
            reserve-=1;
        }

        PrintWriter consoleOutput = new PrintWriter(System.out);
        consoleOutput.println(money);
        StringBuilder countsStr = new StringBuilder();
        for (int count : counts) {
            countsStr.append(count).append(" ");
        }
        consoleOutput.println(countsStr.toString().trim());
        consoleOutput.close();
    }
}
