import java.io.*;

public class bestfit {
    public static void main(String args[]) throws IOException {
        int memorySegments[] = new int[10];
        int allocationFlags[] = new int[10];
        int bestFitIndex = -1;

        DataInputStream in = new DataInputStream(System.in);

        // Input memory segments
        System.out.println("Enter the number of memory segments:");
        int memoryCount = Integer.parseInt(in.readLine());

        System.out.println("Enter the size of memory segments:");
        for (int i = 0; i < memoryCount; i++)
            memorySegments[i] = Integer.parseInt(in.readLine());

        // Display initial memory segments
        System.out.println("\nBefore best fit allocation");
        System.out.println("Index\tMemory Segments");
        for (int i = 0; i < memoryCount; i++)
            System.out.println((i + 1) + "\t" + memorySegments[i]);

        // Input space requirement for the new process
        System.out.println("\nEnter the space requirement for the new process:");
        int spaceRequirement = Integer.parseInt(in.readLine());

        // Best fit allocation
        for (int i = 0; i < memoryCount; i++) {
            if (allocationFlags[i] == 0 && memorySegments[i] >= spaceRequirement) {
                if (bestFitIndex == -1 || memorySegments[i] < memorySegments[bestFitIndex]) {
                    bestFitIndex = i;
                }
            }
        }

        // Display the result
        if (bestFitIndex == -1) {
            System.out.println("\nSpace not available for the new process");
        } else {
            memorySegments[bestFitIndex] = spaceRequirement;
            allocationFlags[bestFitIndex] = 1;

            // Display after best fit allocation
            System.out.println("\nAfter Best Fit Allocation");
            System.out.println("Index\tMemory Segments");
            for (int i = 0; i < memoryCount; i++)
                System.out.println((i + 1) + "\t" + memorySegments[i]);

            System.out.println("\nThe process is allocated to the memory segment " + (bestFitIndex + 1));
        }
    }
}
