package io.groud.leetcode.concurrency;

/**
 * @author Li.Wei by 2020/2/3
 */
public class Temp {
}

class FooBar {
    private volatile boolean tmp = false;
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            if (tmp) {
                wait();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            tmp = true;
            notify();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            if (!tmp) {
                wait();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            tmp = false;
            notify();
        }
    }
}