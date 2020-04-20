package com.daniel;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list = list.insert(list, "danguto@gmail.com");
        list = list.insert(list, "joeli.bastos@gmail.com");
        list = list.insert(list, "daniel.souza@gmail.com");
        list = list.insert(list, "daniel.augusto@gmail.com");
        list = list.insert(list, "daniel.souza@gmail.com");
        list = list.insert(list, "daniel.souza@gmail.com");
        list = list.insert(list, "daniel.souza@gmail.com");

        list.printList(list);
        //list.remove(list,"daniel.souza@gmail.com");
        //list.printList(list);

        LinkedList filtered = new LinkedList();
        filtered = list.removeAllDuplicated(list);

        filtered.printList(filtered);
    }
}
