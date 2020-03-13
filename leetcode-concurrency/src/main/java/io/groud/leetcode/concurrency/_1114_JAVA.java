package io.groud.leetcode.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * https://leetcode-cn.com/problems/print-in-order/
 *
 * @author Li.Wei by 2020/2/3
 */
public class _1114_JAVA {
    class Foo {

        private final CountDownLatch secondLatch = new CountDownLatch(1);
        private final CountDownLatch thirdLatch = new CountDownLatch(1);

        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            secondLatch.countDown(); // 放行 second 方法
        }

        public void second(Runnable printSecond) throws InterruptedException {
            secondLatch.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            thirdLatch.countDown(); // 放行 third 方法
        }

        public void third(Runnable printThird) throws InterruptedException {
            thirdLatch.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}

class _1114_JAVA_1 {
    class Foo {

        private final Semaphore secondLatch = new Semaphore(0);
        private final Semaphore thirdLatch = new Semaphore(0);

        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            secondLatch.release(); // 放行 second 方法
        }

        public void second(Runnable printSecond) throws InterruptedException {

            secondLatch.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            thirdLatch.release(); // 放行 third 方法
        }

        public void third(Runnable printThird) throws InterruptedException {
            thirdLatch.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}