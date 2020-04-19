package com.daniel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String original = sc.nextLine();
        String compare = sc.nextLine();
        boolean work = true;


        //check replaced
        if (original.length() == compare.length()) {
            int count = 0;
            for (int i = 0; i < original.length() && work; i++) {
                //check replaced
                if (original.charAt(i) != compare.charAt(i)) {
                    count++;
                }
                if (count >= 2)
                    work = false;
            }
        } else
            //check added
            if (original.length() < compare.length())
                if (compare.length() - original.length() == 1)
                    for (int i = 0; i < compare.length() - 1 && work; i++) {
                        if (compare.charAt(i) != original.charAt(i))
                            if (original.charAt(i) != compare.charAt(i + 1))
                                work = false;
                    }
                else
                    work = false;
            else
                //check removed
                if (original.length() > compare.length())
                    if (original.length() - compare.length() == 1)
                        for (int i = 0; i < original.length() - 1 && work; i++) {
                            if (compare.charAt(i) != original.charAt(i))
                                if (original.charAt(i + 1) != compare.charAt(i))
                                    work = false;
                        }
                    else
                        work = false;

        System.out.println(work);
    }
}
