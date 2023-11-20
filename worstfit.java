public class worstfit {

    // Function to allocate memory to empty blocks based on the worst fit algorithm.
    static void worstFit(int b_size[], int m, int p_size[], int n) {
        // stores block id of the block which is allocated to a process
        int allocate[] = new int[n];
        // no block is assigned to a process initially
        for (int i = 0; i < allocate.length; i++)
            allocate[i] = -1;
        // select each process and find suitable blocks as per its size
        // block assignment is also done here
        for (int i = 0; i < n; i++) {
            // determine the worst fit block for the current process
            int wstIdx = -1;
            for (int j = 0; j < m; j++) {
                if (b_size[j] >= p_size[i]) {
                    if (wstIdx == -1 || b_size[wstIdx] < b_size[j]) {
                        wstIdx = j;
                    }
                }
            }

            // searching an empty memory block for the current process
            if (wstIdx != -1) {
                // assigning memory block j to the process p[i]
                allocate[i] = wstIdx;

                // Reduce available memory in this block.
                b_size[wstIdx] -= p_size[i];
            }
        }

        System.out.println("\nProcess Number \tProcess Size\tBlock Number ");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i + 1) + "\t\t" + p_size[i] + "\t\t");

            if (allocate[i] != -1)
                System.out.print(allocate[i] + 1);
            else
                System.out.print("Not Allocated");

            System.out.println();
        }
    }

    // Driver code
    public static void main(String[] args) {
        int b_Size[] = {100, 500, 200, 300, 600};
        int p_Size[] = {212, 417, 112, 426};
        int m = b_Size.length;
        int n = p_Size.length;

        worstFit(b_Size, m, p_Size, n);
    }
}
