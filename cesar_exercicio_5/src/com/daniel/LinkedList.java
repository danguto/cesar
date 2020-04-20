package com.daniel;

public class LinkedList {
    Node head;

    class Node {
        String data;
        Node next;

        Node(String d) {
            data = d;
        }
    }

    public LinkedList insert(LinkedList list, String data){

        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null){
            this.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null){
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public LinkedList findFirst(LinkedList list, String data){
        if (list.head != null){
            Node find = list.head;
            while (find.next != null){
                if (find.data == data) {
                    System.out.println("found");
                    break;
                }
                find = find.next;
            }
        }
        return list;
    }

    public LinkedList remove(LinkedList list, String data){
        if (list.head != null){

            Node find = list.head;
            Node prev = null;

            if(find != null && find.data == data){
                list.head = find.next;
                return list;
            }

            while (find != null && find.data != data){
                prev = find;
                find = prev.next;
            }

            if (find != null){
                prev.next = find.next;
            }
        }
        return list;
    }

    public LinkedList removeAllDuplicated(LinkedList list){
        LinkedList filtered = list;
        Node find = list.head;
        Node filter = null;

        while (find.next != null){
            filter = find.next;
            while(filter.next != null){
                if (find.data == filter.data)
                    filtered = remove(filtered,filter.data);
                filter = filter.next;
            }
            find = find.next;
        }
        return filtered;
    }


    public void printList(LinkedList list)
    {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }

        System.out.println();
    }
}
