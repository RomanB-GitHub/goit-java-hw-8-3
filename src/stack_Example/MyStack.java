package stack_Example;
/*
Написать свой класс MyStack как аналог классу Stack, который работает по принципу LIFO (last-in-first-out).

Можно делать либо с помощью Node либо с помощью массива.

Методы

push(Object value) добавляет элемент в конец
remove(int index) удаляет элемент под индексом
clear() очищает коллекцию
size() возвращает размер коллекции
peek() возвращает первый элемент в стеке (LIFO)
pop() возвращает первый элемент в стеке и удаляет его из коллекции
 */

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class MyStack<E> {
    private E[] array;
    private static final int INPUT_SIZE = 10;
    private int size;

    public MyStack() {
        this.array = (E[]) new Object[INPUT_SIZE];
        this.size = 0;
    }

    public void increaseCapacity() {
        array = Arrays.copyOf(array, (size * 3 / 2 + 1));
    }

    //добавляет элемент в конец
    public void push(Object value) {
        if (size == array.length) {
            increaseCapacity();
        }
        array[size] = (E) value;
        size++;

    }

    //удаляет элемент под индексом

    public E remove(int index) {
        Objects.checkIndex(index, size);
        E element = array[index];
        array[index] = null;

        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;

        return element;
    }

    //очищает коллекцию
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
        System.out.println("Stack was cleared!");
    }

    //возвращает размер коллекции
    public int size() {
        return size;
    }

    //возвращает первый элемент в стеке (LIFO)
    public void peek() {
        if (size == 0) {
            throw new EmptyStackException();
        } else {
            E peek = array[size - 1];
            System.out.println("The first element of Stack is : " + peek);
        }
    }

    //возвращает первый элемент в стеке и удаляет его из коллекции
    public void pop() {
        if (size == 0) {
            throw new EmptyStackException();
        } else {
            System.out.println("The first element of Stack is : " + array[size - 1]);
            remove(size - 1);
        }
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }
}
