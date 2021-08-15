package arrayList_Example;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArrayListRealisation {
    public static void main(String[] args) {
        MyArrayListRealisation<String> myArrayListRealisation = new MyArrayListRealisation<>();

        System.out.println(myArrayListRealisation);
        ArrayList<String> arrayList = new ArrayList<>(16);
        System.out.println(arrayList);
        System.out.println("Operation add :");
        MyArrayListRealisation<String> list = new MyArrayListRealisation<>();

        list.add("R");
        list.add("A");
        list.add("K");
        list.add("E");
        list.add("T");
        list.add("A");
        list.add("-");
        list.add("1");
        list.add("2.0");
        list.add("r");

        System.out.println(Arrays.toString(list.getArray()));

        System.out.println("Operation get value #3 :");
        System.out.println(list.get(3));

        System.out.println("Operation size of array :");
        System.out.println("The ArrayList size now consist of " + list.size() + " elements");

        System.out.println("\nOperation remove by index: \"#9\" and \"#8\" and \"#7\" and \"#6\" :");
        list.remove(9);
        list.remove(8);
        list.remove(7);
        list.remove(6);

        System.out.println("The ArrayList size now consist of : " + list.size() + " elements.");
        System.out.println("The ArrayList consists of such elements : " + Arrays.toString(list.getArray()));

        System.out.println("\nThe Operation \"clear\" done!");
        list.clear();
        System.out.println("The ArrayList size now consist of " + list.size() + " elements");

        System.out.println("\nDemonstration is over.\nGood bye!!!");


    }
}
