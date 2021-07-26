package stack_Example;

public class TestMyStack {
    public static void main(String[] args) {
        MyStack<?> stack = new MyStack();

        System.out.println("Push operation!");
        stack.push("Program");
        stack.push('W');
        stack.push(45.984f);
        stack.push(45.6d);
        stack.push(6730000004L);
        for (int i = 0; i <= 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);

        System.out.println("-------------");

        System.out.println("The size of Stack is : " + stack.size());
        System.out.println("-------------");

        System.out.println("Peek operation!");
        stack.peek();
        System.out.println("-------------");

        System.out.println("Pop operation!");
        stack.pop();
        System.out.println("-------------");

        System.out.println("The size of Stack is : " + stack.size());
        System.out.println("-------------");

        System.out.println("Push operation!");
        stack.push(70);
        stack.push(80);
        stack.push(90);
        stack.push(100);
        stack.push(110);
        stack.push(120);
        stack.push(130);

        System.out.println("-------------");

        System.out.println("The size of Stack is : " + stack.size());
        System.out.println("-------------");

        stack.pop();
        System.out.println("Pop it again!");
        stack.pop();
        stack.size();
        System.out.println("-------------");

        System.out.println("Removing by index \"1\"");
        stack.remove(1);
        stack.size();
        System.out.println("-------------");

        System.out.println("Pop operation!");
        stack.pop();
        System.out.println("The size of Stack is : " + stack.size());
        System.out.println("Clear operation!");
        stack.clear();
        System.out.println("The size of Stack is : " + stack.size());
        System.out.println("-------------");

        System.out.println("Lets push five elements in to the Stack now!");
        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);
        stack.push(500);
        System.out.println("The size of Stack is : " + stack.size());
        System.out.println("-------------");

        System.out.println("Clear operation!");
        stack.clear();
        System.out.println("The size of Stack is : " + stack.size());
        System.out.println("-------------");
    }

}
