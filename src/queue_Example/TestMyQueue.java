package queue_Example;

public class TestMyQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);
        myQueue.size();
        System.out.println("Here I will add five elements to MyQueue : 10,20,30,40,50 ! ");
        //добавляет элемент в конец
        MyQueue.add(10);
        MyQueue.add(20);
        MyQueue.add(30);
        MyQueue.add(40);
        MyQueue.add(50);
        System.out.println("--------------");

        myQueue.size();
        System.out.println("--------------");

        //возвращает первый элемент в очереди (FIFO)
        myQueue.peek();
        System.out.println("--------------");

        MyQueue.remove();
        myQueue.size();
        myQueue.peek();
        System.out.println("--------------");

        MyQueue.remove();
        myQueue.size();
        myQueue.peek();
        System.out.println("--------------");

        myQueue.poll();
        myQueue.size();
        System.out.println("--------------");

        MyQueue.add(70);
        MyQueue.add(80);
        MyQueue.add(90);
        MyQueue.add(100);
        MyQueue.add(110);
        MyQueue.add(120);
        myQueue.size();
        System.out.println("--------------");

        MyQueue.removeIndex(7);
        MyQueue.removeIndex(2);
        myQueue.size();
        MyQueue.add(138);
        myQueue.size();
        System.out.println("--------------");

        myQueue.clear();
        myQueue.size();
        System.out.println("--------------");

        MyQueue.add(138);
        MyQueue.add(129);
        MyQueue.add(345);
        MyQueue.add(345);
        MyQueue.add(679);
        MyQueue.add(973);
        myQueue.size();

    }

}
