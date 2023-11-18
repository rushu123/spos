import java.util.Scanner;

public class RoundRobin {

    int burst[], run[], np, quantum = 0, wait[], time = 0, rp = 0, ta[];

    public RoundRobin() {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        np = sc.nextInt();
        rp = np;
        burst = new int[np];
        run = new int[np];
        wait = new int[np];
        ta = new int[np];
        System.out.println("Enter their burst times: ");
        for (int i = 0; i < np; i++) {
            burst[i] = sc1.nextInt();
            run[i] = burst[i];
            wait[i] = 0;
        }
        System.out.println("Enter Quantum: ");
        quantum = sc.nextInt();
        logic();
    }

    public void logic() {
        int i = 0;
        while (rp != 0) {
            if (run[i] > quantum) {
                run[i] = run[i] - quantum;
                time = time + quantum;
                System.out.println("Process: " + i + " ran for Quantum: " + quantum + " at time: " + time);
            } else if (run[i] <= quantum && run[i] > 0) {
                time = time + run[i];
                run[i] = run[i] - run[i];
                ta[i] = time;
                rp--;
                System.out.println("Process: " + i + " ran for Quantum: " + run[i] + " at time: " + time);
            }
            i++;
            if (i == np) {
                i = 0;
            }
        }
        for (int j = 0; j < np; j++) {
            wait[j] = ta[j] - burst[j];
            System.out.println("Turnaround Time for Process " + j + ": " + ta[j]);
            System.out.println("Waiting Time for Process " + j + ": " + wait[j]);
        }
    }

    public static void main(String[] args) {
        new RoundRobin();
    }
}
