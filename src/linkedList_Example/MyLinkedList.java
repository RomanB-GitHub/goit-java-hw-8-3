package linkedList_Example;
import java.util.Arrays;
/*
Написать свой класс MyLinkedList как аналог классу LinkedList.

Нельзя использовать массив. Каждый элемент должен быть отдельным объектом-посредником(Node - нода)
который хранит ссылку на предыдущий и следующий элемент коллекции (двусвязный список).

Методы

add(Object value) добавляет элемент в конец
remove(int index) удаляет элемент под индексом
clear() очищает коллекцию
size() возвращает размер коллекции
get(int index) возвращает элемент под индексом
 */


import java.util.StringJoiner;

public class MyLinkedList<E> {

    private int size ;
    private Node<E> first;
    private Node<E> last;

    public MyLinkedList() {
        this.last = new Node<E>(null, first, null);
        this.first = new Node(null, null, last);
        last.setPrev(first);
        this.size = 0;
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    //добавляет элемент в конец
    public void addLast(E e) {
        Node<E> addedNode = last;
        addedNode.setItem(e);
        last = new Node<>(null, addedNode, null);
        addedNode.setNext(last);
        size++;
    }

    //добавляет элемент в начало
    public void addFirst(E e) {
        Node<E> addedNode = first;
        addedNode.setItem(e);
        first = new Node<>(null,null,addedNode);
        addedNode.setPrev(first);
        size++;
    }

    public int size() {
        return size;
    }

    public E getByIndex(int index) {
        Node<E> target = first.getNext();
        for (int i = 0; i < index; i++) {
            target = getNext(target);
        }
        return target.getItem();
    }

    private Node<E> getNext(Node<E> item) {
        return item.getNext();
    }

    //удаляет элемент под индексом
    public boolean remove(int index) {
        if (index >= 0 && index < size) {
            Node<E> nodeToRemove = getNodeByIndex(index);
            Node<E> nodePrevious = nodeToRemove.getPrev();
            Node<E> nodeNext = nodeToRemove.getNext();
            nodePrevious.setNext(nodeNext);
            nodeNext.setPrev(nodePrevious);
            nodeToRemove = new Node(null, null, null);
            size--;
            return true;
        } else {
            return false;
        }
    }

    private Node<E> getNodeByIndex(int counter) {
        Node<E> target = first.getNext();
        for (int i = 0; i < counter; i++) {
            target = getNext(target);
        }
        return target;
    }



        @Override
    public String toString() {
        String beginning = "MyLinkedList: " + "size=" + size + ", [";
        StringJoiner joiner = new StringJoiner(", ", beginning, "]");
        for (int i = 0; i < size; i++) {
            joiner.add("" + getByIndex(i));
        }

        return joiner.toString();
    }

    //очищает коллекцию
    public void clear() {
        for (int i = 0; i < size; i++) {
            Node<E> node = getNodeByIndex(0);
            node.setPrev(null);
            node.setItem(null);
            node.setNext(null);
        }
        size = 0;
    }


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

    }
}
