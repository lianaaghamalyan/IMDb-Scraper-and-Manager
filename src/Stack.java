import java.util.ArrayList;
import java.util.Scanner;

public class Stack<T> {
    private ArrayList<T> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    // Add an item to the stack
    public void push(T item) {
        stack.add(item);
    }

    // Remove and return the top item from the stack
    public T pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty. Nothing to remove.");
            return null;
        }
        return stack.removeLast();
    }

    // Print all elements in the stack
    public void printAll() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack contains:");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }

    // Search for an item in the stack
//    public boolean search(T item) {
//        return stack.contains(item);
//    }

    public boolean search(String title) {
        for (T item : stack) {
            if (item instanceof Movie && ((Movie) item).getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }


    // Get the size of the stack
    public int size() {
        return stack.size();
    }

    // Get an element by index
    public T get(int index) {
        return stack.get(index);
    }
}
