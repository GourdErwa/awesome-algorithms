package io.groud.leetcode.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/print-zero-even-odd/
 * <p>
 * 输入：n = 5 输出："0102030405"
 *
 * @author Li.Wei by 2020/2/4
 */
public class _1116_JAVA {
    /**
     * 该解法平台报超出时间限制
     * <p>
     * 针对该方法，可以把 wait&notifyAll 舍弃，直接采用无锁方式实现，根据条件判断一直轮询（方法耗时较长时 CPU 占用较高）。
     */
    static class ZeroEvenOdd {
        private volatile int flag = 0;
        private int n;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                if (flag > 0) {
                    wait();
                }
                flag = -flag + 1;
                if (flag > n) {
                    break;
                }
                printNumber.accept(0);
                notifyAll();
            }
        }

        // 偶数
        public synchronized void even(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                while (flag <= 0 || (flag & 1) == 1) {
                    wait();
                }
                if (flag > n) {
                    break;
                }
                printNumber.accept(flag);
                flag = -flag;
                notifyAll();
            }
        }

        // 奇数
        public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                while (flag <= 0 || (flag & 1) == 0) {
                    wait();
                }
                if (flag > n) {
                    break;
                }
                printNumber.accept(flag);
                flag = -flag;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        final _1116_JAVA_1.ZeroEvenOdd o = new _1116_JAVA_1.ZeroEvenOdd(4);

        IntConsumer printNumber = value -> System.out.println(value);

        new Thread(() -> {
            try {
                o.odd(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                o.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                o.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class _1116_JAVA_1 {
    /**
     *
     */
    static class ZeroEvenOdd {
        private final Semaphore z = new Semaphore(1);
        private final Semaphore o = new Semaphore(0);
        private final Semaphore e = new Semaphore(0);

        private int n;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                z.acquire();
                printNumber.accept(0);
                if ((i & 1) == 0) { // 偶数判断
                    o.release();
                } else {
                    e.release();
                }
            }
        }

        // 偶数
        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                e.acquire();
                printNumber.accept(i);
                z.release();
            }
        }

        // 奇数
        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                o.acquire();
                printNumber.accept(i);
                z.release();
            }
        }
    }
}