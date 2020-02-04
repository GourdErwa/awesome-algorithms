package io.groud.leetcode.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode-cn.com/problems/building-h2o/
 *
 * @author Li.Wei by 2020/2/3
 */
public class _1117_JAVA {

    /**
     * Semaphore + CyclicBarrier
     * <p>
     * CyclicBarrier 比较重量级
     */
    class H2O {

        // 信号量 保证 H2/0 线程执行等待状态，即每次只有 2个 H 线程、1个 O 线程可执行
        private final Semaphore h2 = new Semaphore(2, false);
        private final Semaphore o = new Semaphore(1, false);

        // 屏障 ，保证线程三三成组执行
        private final CyclicBarrier barrier = new CyclicBarrier(3);

        public H2O() {
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

            h2.acquire();
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                throw new InterruptedException(e.getMessage());
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            h2.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {

            o.acquire();
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                throw new InterruptedException(e.getMessage());
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            o.release();
        }
    }


    // AtomicInteger
}

class _1117_JAVA_1 {

    /**
     * Semaphore + AtomicInteger
     */
    class H2O {

        // 信号量 保证 H2/0 线程执行等待状态，即每次只有 2个 H 线程、1个 O 线程可执行
        private final Semaphore h2 = new Semaphore(2, false);
        private final Semaphore o = new Semaphore(1, false);

        // 屏障 ，保证线程三三成组执行
        private final AtomicInteger barrier = new AtomicInteger();

        public H2O() {
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            h2.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            barrier.getAndIncrement();
            resetBarrier();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            o.acquire();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            barrier.getAndIncrement();
            resetBarrier();
        }

        private void resetBarrier() {
            if (barrier.compareAndSet(3, 0)) {
                h2.release(2);
                o.release();
            }
        }
    }
}