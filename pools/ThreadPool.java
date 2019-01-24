/**
 *  ThreadPool.java
 *  A ThreadPool class that creates a collection of Threads so that the server can handle requests.
 *  @author: Gabriel Brolo, 15105. Universidad del Valle de Guatemala. Redes.
 *  1/9/2019
 */

package pools;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private final int numThreads;
    private final Worker[] threadPool;
    private final LinkedBlockingQueue queue;

    public ThreadPool(int numThreads) {
        this.numThreads = numThreads;
        threadPool = new Worker[this.numThreads];
        queue = new LinkedBlockingQueue();

        // start all workers
        for (int i = 0; i < numThreads; i++) {
            threadPool[i] = new Worker();
            threadPool[i].start();
        }
    }

    // start threads
    public void execute(Runnable process) {
        synchronized (queue) {
            queue.add(process);
            queue.notify();
        }
    }

    private class Worker extends Thread {
        public void run() {
            Runnable process;

            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch(Exception e) {  }
                    }

                    process = (Runnable) queue.poll();
                }

                try {
                    process.run();
                } catch (Exception e) {  }
            }
        }
    }
}