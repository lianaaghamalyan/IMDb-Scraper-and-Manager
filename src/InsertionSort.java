import java.util.ArrayList;
import java.util.Comparator;

public class InsertionSort {
    public static <T> ArrayList<T> sort(Stack<T> stack, Comparator<T> comparator) {
        ArrayList<T> sortedList = new ArrayList<>(stack.size());
        for (int i = 0; i < stack.size(); i++) {
            sortedList.add(stack.get(i));
        }

        // insertion sort on the list
        int n = sortedList.size();
        for (int i = 1; i < n; i++) {
            T key = sortedList.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(sortedList.get(j), key) > 0) {
                sortedList.set(j + 1, sortedList.get(j));
                j--;
            }
            sortedList.set(j + 1, key);
        }

        return sortedList;
    }
}