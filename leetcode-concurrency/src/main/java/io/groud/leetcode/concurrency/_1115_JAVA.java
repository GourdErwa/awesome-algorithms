package io.groud.leetcode.concurrency;

/**
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 * <p>
 * 解题思路： - 2 个线程异步启动，分别调用一个实例对象的成员方法 - 必须保证 foo 方法执行后执行 bar 方法，以保证字符串正确打印
 *
 * @author Li.Wei by 2020/2/4
 */
public class _1115_JAVA {}

class _1115_JAVA_1 {

    static class FooBar {
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

    public static void main(String[] args) {
        final FooBar fooBar = new FooBar(5);

        new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}