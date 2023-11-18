import java.util.Scanner;

public class Priority {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes:");
        int n = sc.nextInt();
        int i, pos = 0, temp;

        System.out.println("Enter burst times:");
        int p[] = new int[n]; // process IDs
        int bt[] = new int[n]; // burst times
        int pt[] = new int[n]; // priority times
        int wt[] = new int[n]; // waiting times
        int tat[] = new int[n]; // turnaround times

        for (i = 0; i < n; i++) {
            p[i] = i + 1;
            bt[i] = sc.nextInt();
        }

        System.out.println("Enter priority times:");
        for (i = 0; i < n; i++) {
            pt[i] = sc.nextInt();
        }

        // Sort the processes by priority
        for (i = 0; i < n; i++) {
            pos = i;
            for (int j = i + 1; j < n; j++) {
                if (pt[j] < pt[pos]) {
                    pos = j;
                }
            }
            // Swap values to maintain the same order for p, bt, and pt
            temp = pt[pos];
            pt[pos] = pt[i];
            pt[i] = temp;

            temp = p[pos];
            p[pos] = p[i];
            p[i] = temp;

            temp = bt[pos];
            bt[pos] = bt[i];
            bt[i] = temp;
        }

        wt[0] = 0;

        for (i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
        }

        System.out.println("Process\tBT\tPriority\tWaiting Time\tTAT");

        for (i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
            System.out.println(p[i] + "\t" + bt[i] + "\t" + pt[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
        }
    }
}
