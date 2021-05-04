package io.github.xinshepherd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用锁模拟生产者消费者
 */
public class ReentrantLockObserver {

    private static final int FULL = 10;
    private int count;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    class Producer implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    lock.lock();
                    while (count == FULL) {
                        notFull.await();
                    }
                    count++;
                    System.out.println("Producer[" + Thread.currentThread().getName() + "] current count: " + count);
                    notEmpty.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();

                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    lock.lock();
                    while (count == 0) {
                        notEmpty.await();
                    }
                    count--;
                    System.out.println("Consumer[" + Thread.currentThread().getName() + "] current count: " + count);
                    notFull.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    void test() {
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();

    }


    public static void main(String[] args) throws InterruptedException {
        ReentrantLockObserver observer = new ReentrantLockObserver();
        observer.test();
        Thread.sleep(1000);

    }

}
