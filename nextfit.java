import java.util.Scanner;

public class nextfit {

    static void nextFit(int[] blockSize, int[] processSize) {
        int m = blockSize.length;
        int n = processSize.length;
        int[] allocation = new int[n];
        int blockIndex = 0;

        for (int i = 0; i < n; i++) {
            while (blockIndex < m && blockSize[blockIndex] < processSize[i]) {
                blockIndex++;
            }

            if (blockIndex < m) {
                allocation[i] = blockIndex + 1;
                blockSize[blockIndex] -= processSize[i];
            } else {
                blockIndex = 0;
                i--; // Retry the current process in the next iteration
            }
        }

        System.out.println("\nProcess Number \tProcess Size\tBlock Number ");
        for (int i = 0; i < n; i++) {
            System.out.printf(" %d\t\t\t%d\t\t\t%s\n", i + 1, processSize[i],
                    allocation[i] != 0 ? String.valueOf(allocation[i]) : "Not Allocated");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of memory blocks:");
        int m = scanner.nextInt();

        System.out.println("Enter the sizes of memory blocks:");
        int[] blockSize = new int[m];
        for (int i = 0; i < m; i++) {
            blockSize[i] = scanner.nextInt();
        }

        System.out.println("Enter the number of processes:");
        int n = scanner.nextInt();

        System.out.println("Enter the sizes of processes:");
        int[] processSize = new int[n];
        for (int i = 0; i < n; i++) {
            processSize[i] = scanner.nextInt();
        }

        nextFit(blockSize, processSize);

        scanner.close();
    }
}
