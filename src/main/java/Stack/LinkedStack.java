package Stack;

import java.time.Instant;
import java.util.NoSuchElementException;

public class LinkedStack<T extends Comparable<T>> implements Stack<T> {

    Node top;
    int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(T object) {
        Node newNode = new Node<>(object);
        if (newNode == null) {
            return;
        }
        newNode.next = top;
        top = newNode;
        size++;

    }

    @Override
    public T pop() {
        if (top == null) {
            return null;
        }
        T data = (T) top.data;
        top = top.next;
        return data;
    }

    @Override
    public T peek() {
        try {
            return (T) top.data;
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return size;
    }

    public void display() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println();
    }

    public void sort() {
        if (!isEmpty()) {
            T temp = pop();
            sort();
            insertSorted(temp);
        }
    }

    private void insertSorted(T temp) {
        if (isEmpty() || temp.compareTo(peek()) >= 0) {
            push(temp);
        } else {
            T temp2 = pop();
            insertSorted(temp);
            push(temp2);
        }
    }
}