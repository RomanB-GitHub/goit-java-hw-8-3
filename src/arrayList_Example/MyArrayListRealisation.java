package arrayList_Example;

import java.util.*;

/*
Написать свой класс MyArrayList как аналог классу ArrayList.

Можно использовать 1 массив для хранения данных.

Методы

add(Object value) добавляет элемент в конец
remove(int index) удаляет элемент под индексом
clear() очищает коллекцию
size() возвращает размер коллекции
get(int index) возвращает элемент под индексом
 */
public class MyArrayListRealisation<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private E [] array;
    private int size;

    public MyArrayListRealisation() {
        this.array = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public E[] getArray() {
        return array;
    }

    //добавляет элемент в конец
    public boolean add(E value) {
        if (size == array.length) {
            resize();
        }
        array[size] = value;
        size++;
        return true;
    }

    private void resize() {
        array = (E[]) Arrays.copyOf(array, (size * 3 / 2 + 1));
    }


    //удаляет элемент под индексом
    public void remove(int index) {
        E[] arrayCopy = Arrays.copyOf(array, array.length);
        array = (E[]) new Object[array.length];
        for (int i = 0, j = 0; i < arrayCopy.length; i++) {
            if (i != index) {
                array[j++] = arrayCopy[i];
            }
        }
    }

    //возвращает размер коллекции
    public int size() {
        int counter = 0;
        for (E element : array) {
            if (element != null) {
                counter++;
            }
        }
        return counter;
    }

    //очищает коллекцию
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }


    //возвращает элемент под индексом
    public E get(int index) {
        E result = null;
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                result = array[i];
            }

        }
        return result;
    }


}
