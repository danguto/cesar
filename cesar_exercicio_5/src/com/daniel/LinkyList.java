package com.daniel;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkyList {

    public static void main(String[] args) {
        LinkedList<String> lst = new LinkedList<>();

        lst.add("danguto@gmail.com");
        lst.add("joeli.bastos@gmail.com");
        lst.add("daniel.souza@gmail.com");
        lst.add("daniel.augusto@gmail.com");
        lst.add("daniel.souza@gmail.com");
        lst.add("daniel.souza@gmail.com");
        lst.add("daniel.souza@gmail.com");

        System.out.println("without:");
        System.out.println(lst);

        for (int i = 0; i < lst.size(); i++) {
            String temp = lst.get(i);
            for (int j = i + 1; j < lst.size(); j++) {
                String temp2 = lst.get(j);
                if (temp.equals(temp2)){
                    lst.remove(j);
                    j--;
                }
            }
        }

        System.out.println("filtered:");
        System.out.println(lst);

    }
}
