package arrayList_Example;

import java.util.Arrays;

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
public class MyArrayListRealisation {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public Object[] getArray() {
        return array;
    }

    public MyArrayListRealisation() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    //добавляет элемент в конец
    public boolean add(Object value) {
        if (size == array.length) {
            resize();
        }
        array[size] = value;
        size++;
        return true;
    }

    private void resize() {
        array = Arrays.copyOf(array, (size * 3 / 2 + 1));
    }


    //удаляет элемент под индексом
    public void remove(int index) {
        Object[] arrayCopy = Arrays.copyOf(array, array.length);
        array = new Object[array.length];
        for (int i = 0, j = 0; i < arrayCopy.length; i++) {
            if (i != index) {
                array[j++] = arrayCopy[i];
            }
        }
    }

    //возвращает размер коллекции
    public int size() {
        int counter = 0;
        for (Object element : array) {
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
    public Object get(int index) {
        Object result = null;
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                result = array[i];
            }

        }
        return result;
    }


}
