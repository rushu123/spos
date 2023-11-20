 public class firstfit
{
    public static void main (String[]args)
    {

        int blockSize[] = {100, 50, 30, 120, 35};
        int processSize[] = {20, 60, 70, 40};
        int m = blockSize.length;
        int n = processSize.length;
        implimentFirstFit(blockSize, m, processSize, n);
    }

    static void implimentFirstFit(int blockSize[], int blocks, int processSize[], int processes) {
        // This will store the block id of the allocated block to a process
        int allocate[] = new int[processes];
        int occupied[] = new int [blocks];

        // initially assigning -1 to all allocation indexes
        // means nothing is allocated currently
        for (int i = 0; i < allocate.length; i++)
            allocate[i] = -1;

        // take each process one by one and find
        // first block that can accommodate it
        for (int i = 0; i < processes; i++)
        {
            for (int j = 0; j < blocks; j++) {
                if (blockSize[j] >= processSize[i])
                {
                    // allocate block j to p[i] process
                    allocate[i] = j;

                    // Reduce size of block j as it has accommodated p[i]
                    blockSize[j] -= processSize[i];

                    break;
                }
            }
        }

        System.out.println("\nProcess No.\tProcess Size\tBlock no.\n");
        for (int i = 0; i < processes; i++)
        {
            System.out.print(i + 1 + "\t\t\t" + processSize[i] + "\t\t\t");
            if (allocate[i] != -1)
                System.out.println(allocate[i] + 1);
            else
                System.out.println("Not Allocated");
        }
    }
}