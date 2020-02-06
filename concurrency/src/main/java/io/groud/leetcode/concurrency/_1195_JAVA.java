package io.groud.leetcode.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/fizz-buzz-multithreaded/
 *
 * @author Li.Wei by 2020/2/6
 */
public class _1195_JAVA {
    /**
     * 使用信号量控制
     * 考虑最终信号量释放问题，保证程序正常结束
     */
    static class FizzBuzz {
        private int n;

        Semaphore fizzSem = new Semaphore(0);
        Semaphore buzzSem = new Semaphore(0);
        Semaphore fizzBuzzSem = new Semaphore(0);
        Semaphore numSem = new Semaphore(1);

        private int i;

        public FizzBuzz(int n) {
            //从1开始
            this.i = 1;
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (true) {
                fizzSem.acquire();
                if (i > n) {
                    break;
                }
                printFizz.run();
                i++;
                numSem.release();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (true) {
                buzzSem.acquire();
                if (i > n) {
                    break;
                }
                printBuzz.run();
                i++;
                numSem.release();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (true) {
                fizzBuzzSem.acquire();
                if (i > n) {
                    break;
                }
                printFizzBuzz.run();
                i++;
                numSem.release();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            ///主要是这儿执行完后其他的还在等，所以会超时，这个时候释放掉所有的就行了。
            while (i <= n) {
                numSem.acquire();
                if (i % 3 == 0 && i % 5 == 0) {
                    fizzBuzzSem.release();
                } else if (i % 3 == 0) {
                    fizzSem.release();
                } else if (i % 5 == 0) {
                    buzzSem.release();
                } else {
                    if (i <= n) {
                        printNumber.accept(i);
                    }
                    i++;
                    numSem.release();
                }
            }
            release(); // 最终释放许可
        }

        private void release() {
            fizzBuzzSem.release();
            buzzSem.release();
            fizzSem.release();
        }
    }

    public static void main(String[] args) {
        final _1195_JAVA.FizzBuzz o = new _1195_JAVA.FizzBuzz(5);

        IntConsumer printNumber = value -> System.out.println(value);

        new Thread(() -> {
            try {
                o.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                o.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                o.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                o.number(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class _1195_JAVA_1 {
    /**
     * 使用信号量 + for 循环内部对变量的判断控制
     * 该实现考虑，如果某方法耗时较长时性能问题
     */
    class FizzBuzz {
        private Semaphore semaphore = new Semaphore(1);

        private int curNum = 1;

        private int n;

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (; ; ) {
                // Acquire the permit, try to run the logic exclusively.
                this.semaphore.acquire(1);

                try {
                    if (this.curNum > n) {
                        return;
                    }

                    if ((this.curNum % 3 == 0) && (this.curNum % 5 != 0)) {
                        printFizz.run();
                        this.curNum++;
                    }
                } finally {
                    // Release the permit anyway.
                    this.semaphore.release(1);
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (; ; ) {
                this.semaphore.acquire(1);

                try {
                    if (this.curNum > n) {
                        return;
                    }

                    if ((this.curNum % 3 != 0) && (this.curNum % 5 == 0)) {
                        printBuzz.run();
                        this.curNum++;
                    }
                } finally {
                    this.semaphore.release(1);
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (; ; ) {
                this.semaphore.acquire(1);

                try {
                    if (this.curNum > n) {
                        return;
                    }

                    if ((this.curNum % 3 == 0) && (this.curNum % 5 == 0)) {
                        printFizzBuzz.run();
                        this.curNum++;
                    }
                } finally {
                    this.semaphore.release(1);
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (; ; ) {
                this.semaphore.acquire(1);

                try {
                    if (this.curNum > n) {
                        return;
                    }

                    if ((this.curNum % 3 != 0) && (this.curNum % 5 != 0)) {
                        printNumber.accept(this.curNum);
                        this.curNum++;
                    }
                } finally {
                    this.semaphore.release(1);
                }
            }
        }
    }
}
