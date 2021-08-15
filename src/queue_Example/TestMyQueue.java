package queue_Example;

public class TestMyQueue {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue(5);
        myQueue.size();
        System.out.println("Here I will add five elements to MyQueue : 10,20,30,40,50 ! ");
        //добавляет элемент в конец
        myQueue.add(10);
        myQueue.add(20);
        myQueue.add(30);
        myQueue.add(40);
        myQueue.add(50);
        System.out.println("--------------");

        myQueue.size();
        System.out.println("--------------");

        //возвращает первый элемент в очереди (FIFO)
        myQueue.peek();
        System.out.println("--------------");

        myQueue.remove();
        myQueue.size();
        myQueue.peek();
        System.out.println("--------------");

        myQueue.remove();
        myQueue.size();
        myQueue.peek();
        System.out.println("--------------");

        myQueue.poll();
        myQueue.size();
        System.out.println("--------------");

        myQueue.add(70);
        myQueue.add(80);
        myQueue.add(90);
        myQueue.add(100);
        myQueue.add(110);
        myQueue.add(120);
        myQueue.size();
        System.out.println("--------------");

        myQueue.removeIndex(7);
        myQueue.removeIndex(2);
        myQueue.size();
        myQueue.add(138);
        myQueue.size();
        System.out.println("--------------");

        myQueue.clear();
        myQueue.size();
        System.out.println("--------------");

        myQueue.add(138);
        myQueue.add(129);
        myQueue.add(345);
        myQueue.add(345);
        myQueue.add(679);
        myQueue.add(973);
        myQueue.size();

    }

}
