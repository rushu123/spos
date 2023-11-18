import java.util.Scanner;

public class PreemptiveSJF {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        int n = sc.nextInt();
        int pid[] = new int[n];   // process IDs
        int ar[] = new int[n];     // arrival times
        int bt[] = new int[n];     // burst or execution times
        int ct[] = new int[n];     // completion times
        int ta[] = new int[n];     // turn around times
        int wt[] = new int[n];     // waiting times
        int f[] = new int[n];
        int k[] = new int[n];
        int temp, tot = 0, st = 0;
        float avgwt = 0, avgta = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter process " + (i + 1) + " arrival time: ");
            ar[i] = sc.nextInt();
            System.out.println("Enter process " + (i + 1) + " burst time: ");
            bt[i] = sc.nextInt();
            k[i] = bt[i];
            pid[i] = i + 1;
        }

        while (true) {
            int min = 999, c = n; // Set min to a high value for comparison

            if (tot == n)
                break;

            for (int i = 0; i < n; i++) {
                if (ar[i] <= st && f[i] == 0 && bt[i] < min) {
                    min = bt[i];
                    c = i;
                }
            }

            if (c == n)
                st++;
            else {
                bt[c]--;
                st++;
                if (bt[c] == 0) {
                    ct[c] = st;
                    f[c] = 1;
                    tot++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            ta[i] = ct[i] - ar[i];
            wt[i] = ta[i] - k[i];
            avgwt += wt[i];
            avgta += ta[i];
        }

        System.out.println("PID  Arrival  Burst  Completion Turnaround Waiting");
        for (int i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t" + ar[i] + "\t" + k[i] + "\t" + ct[i] + "\t" + ta[i] + "\t" + wt[i]);
        }

        System.out.println("\nAverage Turnaround Time is " + (float) (avgta / n));
        System.out.println("Average Waiting Time is " + (float) (avgwt / n));
        sc.close();
    }
}
