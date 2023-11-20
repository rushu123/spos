import java.util.*;

public class lifo {
    private final int capacity;
    private final Deque<Integer> stack;

    public lifo(int capacity) {
        this.capacity = capacity;
        this.stack = new LinkedList<>();
    }

    public void referencePage(int pageNumber) {
        if (stack.size() == capacity) {
            System.out.println("Page " + stack.removeFirst() + " removed from memory.");
        }

        stack.addFirst(pageNumber);
        System.out.println("Page " + pageNumber + " added to memory.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the memory: ");
        int capacity = scanner.nextInt();

        lifo lifo = new lifo(capacity);

        System.out.print("Enter the number of page references: ");
        int numReferences = scanner.nextInt();

        System.out.println("Enter the page references:");
        for (int i = 0; i < numReferences; i++) {
            lifo.referencePage(scanner.nextInt());
        }

        scanner.close();
    }
}
