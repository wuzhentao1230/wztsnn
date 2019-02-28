package lock.ReentrantLock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Reenlock {
    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    private void increment() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }

    public void Thread1() throws InterruptedException {
        lock.lock();

        System.out.println("You gotta wait now!");
        cond.await();

        System.out.println("Come on! You woke me up!");

        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void Thread2() throws InterruptedException {
        Thread.sleep(1000);
        lock.lock();

        System.out.println("Press the return key");
        new Scanner(System.in).nextLine();
        System.out.println("Return key was just clicked!");

        cond.signal();

        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void finished() {
        System.out.println("Count is: " + count);
    }


    public static void main(String[] args) throws Exception {

        final Reenlock reenlock = new Reenlock();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    reenlock.Thread1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    reenlock.Thread2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        reenlock.finished();
    }
}
