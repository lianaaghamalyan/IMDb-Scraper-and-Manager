import java.util.ArrayList;
import java.util.Scanner;

public class Stack<T> {
    private ArrayList<T> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return stack.remove(stack.size() - 1); // Remove from the top (LIFO)
    }

    public T peek() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return stack.get(stack.size() - 1); // Peek the top element
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public T get(int index) { // Allow access by index
        return stack.get(index);
    }

    public void set(int index, T value) { // Allow setting by index
        stack.set(index, value);
    }

    public void printAll() {
        // Automatically print in LIFO order
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }

    //    public boolean search(T item) {
//        return stack.contains(item);
//    }

    //    public boolean search(String title) {
//        for (T item : stack) {
//            if (item instanceof Movie && ((Movie) item).getTitle().equalsIgnoreCase(title)) {
//                return true;
//            }
//        }
//        return false;
//    }


    // Method to search movies until user types "End"
    public void searchByUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean found;

        while (true) {
            System.out.println("\nEnter the title of the movie to search or type 'End' to exit: ");
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("End")) {
                System.out.println("Exiting the search.");
                break;
            }

            // Search for the movie title in the stack
            found = false;
            for (T movie : stack) {
                if (movie instanceof Movie && ((Movie) movie).getTitle().toLowerCase().contains(input.toLowerCase())) {
                    System.out.println("Found: " + movie);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Movie not found. Try again.");
            }
        }
    }
}
