package com.daniel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String original = sc.nextLine();
        String compare = sc.nextLine();
        Boolean work = true;
        int count = 0;

        if (original.charAt(0) == compare.charAt(0)) {
            if (original.length() > 3) {
                for (int i = 1; i < original.length() && work; i++) {
                    if (original.charAt(i) != compare.charAt(i))
                        count++;
                    if (count >= original.length() * 2 / 3)
                        work = false;
                }
            }
        } else
            work = false;
        System.out.println(work);
    }
}
