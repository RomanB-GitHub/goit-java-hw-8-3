package linkedList_Example;

import java.util.Arrays;

public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<String>();

        System.out.println("Size of the  list is : " + list.size());
        list.add("Java");
        list.add("C#");
        System.out.println("\n New size is : "+list.size());
        System.out.println(list.toString()
        );
        list.addFirst("Python");
        list.addFirst("JavaScript");
        System.out.println("\nWas added two elements to the head");
        System.out.println(list.toString());
        System.out.println("Let's remove first element " + list.remove(0));
        System.out.println(list);
        System.out.println("\nTrying to remove 7-th element " + list.remove(7));
        System.out.println(list);
        list.clear();
        System.out.println(list);






    }
}
