package homework.homework20;

import java.util.concurrent.atomic.AtomicInteger;

public class MainCount {
    static Integer COUNT = 0;
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    static Integer COUNT2 = 0;

    public static void main(String[] args) {

        Counter counter = new Counter();
        Counter2 counter2 = new Counter2();
        AtomicCounter atomicCounter = new AtomicCounter();
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(counter);
            thread1.start();
        }
        for (int i = 0; i < 10; i++) {
            Thread thread2 = new Thread(atomicCounter);
            thread2.start();
        }
        for (int i = 0; i < 10; i++) {

            Thread thread3 = new Thread(counter2);
            thread3.start();

        }
        System.out.println("SYNCHRONIZED: " + COUNT);
        System.out.println("ATOMIC INTEGER: " + atomicInteger);
        System.out.println("NOTHING: " + COUNT2);
    }


    static void nextCounter() {
        COUNT++;
    }

    static void nextCounter2() {
        COUNT2++;
    }

    static void nextAtomicCounter() {
        atomicInteger.incrementAndGet();
    }

    static class Counter implements Runnable {
        synchronized public void run() {
            for (int i = 0; i < 1000; i++) {
                nextCounter();

            }
        }
    }

    static class AtomicCounter implements Runnable {
        public void run() {
            for (int i = 0; i < 1000; i++) {
                nextAtomicCounter();

            }
        }
    }

    static class Counter2 implements Runnable {
        public void run() {
            for (int i = 0; i < 1000; i++) {
                nextCounter2();

            }
        }
    }
}