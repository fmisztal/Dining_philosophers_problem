package Lab3.Zad_4;

public class PhilosopherTable {
    public static void main(String[] args) {
        int numOfPhilosophers = 5;

        Philosopher[] philosophers = new Philosopher[numOfPhilosophers];
        Object[] forks = new Object[numOfPhilosophers];

        for (int i = 0; i < forks.length; i++)
            forks[i] = new Object();

        for (int i = 0; i < philosophers.length; i++) {
            Object rightFork = forks[i];
            Object leftFork = forks[(i + 1) % forks.length];
            philosophers[i] = new Philosopher(rightFork, leftFork);

            if (i == philosophers.length - 1)
                philosophers[i] = new Philosopher(leftFork, rightFork);
            else
                philosophers[i] = new Philosopher(rightFork, leftFork);

            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}
