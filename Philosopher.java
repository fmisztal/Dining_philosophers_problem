package Lab3.Zad_4;

public class Philosopher implements Runnable{
    private final Object rightFork;
    private final Object leftFork;

    public Philosopher(Object rightFork, Object leftFork) {
        this.rightFork = rightFork;
        this.leftFork = leftFork;
    }

    private void doSomething(String activity) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ": " + activity);
        Thread.sleep((int) (Math.random() * 100));
    }

    @Override
    public void run() {
        try {
            while (true) {
                doSomething("Sitting");
                synchronized (rightFork) {
                    doSomething("Picked up right fork");
                    synchronized (leftFork) {
                        doSomething("Picked up left fork - eating");
                        doSomething("Put down left fork");
                    }
                    doSomething("Put down right fork - sitting");
                }
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
