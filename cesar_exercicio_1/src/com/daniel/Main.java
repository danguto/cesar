package com.daniel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int number = sc.nextInt();

        char output[] = new char[number];
        int index = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                output[index] = '&';
                output[index + 1] = '3';
                output[index + 2] = '2';
                index += 3;
            } else {
                output[index] = input.charAt(i);
                index++;
            }
        }
        System.out.println(output);

    }

}

