import java.lang.reflect.Array;
import java.util.Arrays;

class Stack<T> {
    private T[] arr;
    private int capacity;
    private int top;
    Stack(Class<T> c, int size) {
        arr = (T[]) Array.newInstance(c, size);
        capacity = size;
        top = -1;
    }
    public void push(T x) {
        if (isFull()) {
            System.out.println("OverFlow\nProgram Terminated\n");
            System.exit(1);
        }
        arr[++top] = x;
    }
    public T pop() {
        if (isEmpty()) {
            System.out.println("STACK EMPTY");
            System.exit(1);
        }
        return arr[top--];
    }

    public T peek() {
        return arr[top];
    }
    public int size() {
        return top + 1;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public Boolean isFull() {
        return top == capacity - 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

}
