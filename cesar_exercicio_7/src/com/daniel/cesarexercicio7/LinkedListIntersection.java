package com.daniel.cesarexercicio7;

import java.util.LinkedList;

public class LinkedListIntersection {

    LinkedList<String> first = new LinkedList<String>();

    LinkedList<String> second = new LinkedList<String>();

    public static void main(String[] args) {

        LinkedListIntersection link = new LinkedListIntersection();

        //populate LinkedList first
        link.first.add("danguto@gmail.com");
        link.first.add("joeli.bastos@gmail.com");
        link.first.add("daniel.souza@gmail.com");
        link.first.add("daniel.augusto@gmail.com");
        link.first.add("daniel.souza@gmail.com");
        link.first.add("daniel.souza@gmail.com");
        link.first.add("daniel.souza@gmail.com");

        //populate LinkedList second
        link.second.add("joeli.bastos@gmail.com");
        link.second.add("daniel.souza@gmail.com");
        link.second.add("daniel.souza@gmail.com");
        link.second.add("daniel.souza@gmail.com");
        link.second.add("daniel.souza@gmail.com");

        //Find Longest LinkedList
        LinkedList<String> longest = link.findLongest(link.first, link.second);
        //Find intersection based on longest index
        int longestIndex = link.getIntersectionIndex(link.first, link.second);
        //Find value of node
        if (longestIndex > 0) {
            String value = longest.get(longestIndex);
            //print value
            System.out.println(value);
        } else {
            System.out.println("Not Found");
        }



    }

    public LinkedList<String> findLongest (LinkedList<String> a, LinkedList b){

        int lengthA = a.size();
        int lengthB = b.size();
        int diff = lengthA - lengthB;

        if (diff > 0)
            return a;
        else
            return b;
    }


    public int getIntersectionIndex(LinkedList<String> a, LinkedList b) {

        int lengthA = a.size();
        int lengthB = b.size();
        int diff = lengthA - lengthB;

        //if lenght of both LinkedList is equal
        if (diff == 0) {
            for (int i = 0; i < lengthA; i++) {
                if (a.get(i).equals(b.get(i)))
                    return i;
            }
            return -1;
        } else if (diff > 0) // if A is longer than B
            return getIndex(diff, a, b);
        else // if B is longer than A
            return getIndex(Math.abs(diff)/*convert to absolute value*/, a, b);

    }

    private int getIndex(int diff, LinkedList<String> linkLong, LinkedList linkShort) {

        //check if it equal
        for (int i = 0; i < linkShort.size(); i++) {
            if (linkLong.get(i + diff).equals(linkShort.get(i)))
                // return value based on Longest Linked List
                return i + diff;
        }

        return -1;
    }

}

