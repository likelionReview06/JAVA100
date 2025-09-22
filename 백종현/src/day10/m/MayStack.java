package day10.m;

public class MayStack <T>{
    private final T[] stack;
    private int top;
    private final int maxSize;

    public MayStack(int maxSize){
        stack =  (T[]) new Object[maxSize];
        top = -1;
        this.maxSize = maxSize;
    }

    public void push(T item){
        if (isFull()){
            System.out.println("Stack is full");
            return;
        }
        stack[++top] = item;
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        return stack[top--];
    }

    public T peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        return stack[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public int size(){
        return top + 1;
    }

    public void clear(){
        top = -1;
    }

    public void print(){
        for(int i = 0; i < size(); i++){
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MayStack<Integer> stack = new MayStack<>(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);

        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.peek());
        stack.print();
        System.out.println(stack.isEmpty());
        stack.clear();
        stack.print();
        System.out.println(stack.isEmpty());
    }
}
