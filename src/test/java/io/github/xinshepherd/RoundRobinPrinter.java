package io.github.xinshepherd;

/**
 * 轮流打印
 */
public class RoundRobinPrinter {

    private int current = 0;
    private final int maxNumber;
    private final int maxCount;
    private final Object lock = new Object();

    public RoundRobinPrinter(int maxNumber, int maxCount) {
        this.maxNumber = maxNumber;
        this.maxCount = maxCount;
    }

    class Printer implements Runnable {

        private final int number;

        public Printer(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (current <= maxCount) {
                synchronized (lock) {
                    while (current % maxNumber != number) {
                        try {
                            lock.wait();
                            if (current > maxCount)
                                return;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.printf("Thread-%s: %s%n", number + 1, current);
                    current++;
                    lock.notifyAll();
                }
            }
        }

    }

    void run() {
        for (int i = 0; i < maxNumber; i++) {
            new Thread(new Printer(i)).start();
        }
    }

    public static void main(String[] args) {
        int maxNumber = 4;

        RoundRobinPrinter printer = new RoundRobinPrinter(maxNumber, 7);
        printer.run();

    }

}
