package exercicio2;

public class PilhaObj<T> {

    private T[] stack;
    private int top;

    public PilhaObj(int size) {
        stack = (T[]) new Object[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public void push(T element) {
        if (!isFull()) {
            stack[++top] = element;
        } else {
            System.out.println("Pilha cheia!");
        }
    }

    public T pop() {
        if (!isEmpty()) {
            return stack[top--];
        }
        System.out.println("Pilha vazia!");
        return null;
    }

    public T peek() {
        if (!isEmpty()) {
            return stack[top];
        }
        return null;
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }

}
