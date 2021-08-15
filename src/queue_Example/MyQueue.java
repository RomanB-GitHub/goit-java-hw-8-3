package queue_Example;

/*
Написать свой класс MyQueue как аналог классу Queue, который будет работать по принципу FIFO (first-in-first-out).

Можно делать либо с помощью Node либо с помощью массива.

Методы

add(Object value) добавляет элемент в конец
remove(int index) удаляет элемент под индексом
clear() очищает коллекцию
size() возвращает размер коллекции
peek() возвращает первый элемент в очереди (FIFO)
poll() возвращает первый элемент в очереди и удаляет его из коллекции
 */
public class MyQueue<E> {
    private  E[] queueArray;
    private static int maxSize; // max amount of elements in Queue
    private static int frontElement;
    private static int rearElement;

    public MyQueue(int size) {
        maxSize = size;
        queueArray = (E[])new Object[maxSize];
        rearElement = 0;
        frontElement = 0;
    }

    //добавляет элемент в конец
    public void add(E data) {
        if (maxSize == rearElement) {
            System.out.println("The Queue if  full now");
        } else {
            queueArray[rearElement] = data;
            System.out.println(data + " was added to Queue!");
            rearElement++;
        }
    }

    //удаляет элемент
   public void remove() {
        if (frontElement == rearElement) {
            System.out.println("The Queue is empty");
        } else {
            for (int i = 0; i < rearElement - 1; i++) {
                queueArray[i] = queueArray[i + 1];
            }
            if (rearElement < maxSize)
                queueArray[rearElement] = null;
            rearElement--;
            System.out.println("Removing of element was complete!");
        }
    }

    //удаляет элемент под индексом
    public void removeIndex(int index) {
        if (frontElement == rearElement) {
            System.out.println("The Queue is empty");
        }
        if (index > maxSize) {
            System.out.println("There is no this index in the Queue!");
        } else {
            System.out.printf("\nThe element under this %d index was deleted!\n", index);
            for (int i = 0, k = 0; i < queueArray.length; i++) {
                if (i != index) {
                    queueArray[k++] = queueArray[i];
                }
            }
            if (rearElement < maxSize) {
                queueArray[rearElement] = null;
                rearElement--;
            }
        }

    }

    //возвращает первый элемент в очереди (FIFO)
    public void peek() {
        if (frontElement == rearElement) {
            System.out.println("The Queue is empty");
        }
        System.out.printf("\nFor now the front element is %d.\n", queueArray[frontElement]);
    }

    //возвращает первый элемент в очереди и удаляет его из коллекции
    public void poll() {
        if (frontElement == rearElement) {
            System.out.println("The Queue is empty");
        }
        E temp = queueArray[frontElement];// получаем первый елемент из очереди
        System.out.printf("\nFor now the front element is %d, and let's delete it! \n", temp);
        for (int i = 0; i < rearElement; i++) {
            queueArray[i] = queueArray[i + 1];
        }
        if (rearElement < maxSize) {
            queueArray[rearElement] = null;
            rearElement--;
        }
    }

    //очищает коллекцию
    public void clear() {
        while (frontElement != rearElement) {
            for (int i = 0; i < rearElement - 1; i++) {
                queueArray[i] = queueArray[i + 1];
            }
            if (rearElement < maxSize) {
                queueArray[rearElement] = null;
                rearElement--;
            }
        }
        System.out.println("The queue was clear!!!");
    }

    //возвращает размер коллекции
    public void size() {
        int counter = 0;
        if (frontElement == rearElement) {
            System.out.println("The Queue is empty");
        }
        for (int i = 0; i < rearElement; i++) {
            if (queueArray[i] != null) {
                counter++;
                System.out.printf("%d <-- ", queueArray[i]);
            }
        }
        System.out.println("\nTotal size of queue is : " + counter + " elements");
    }

}
