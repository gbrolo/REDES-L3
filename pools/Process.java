/**
 *  Process.java
 *  A simple class that extends Runnable and starts a thread that the server will use to respond to requests.
 *  @author: Gabriel Brolo, 15105. Universidad del Valle de Guatemala. Redes.
 *  1/9/2019
 */

package pools;

public class Process implements Runnable {
    private Thread requestThread;

    public Process(Thread requestThread) {
        this.requestThread = requestThread;
    }

    public void run() {
        this.requestThread.start();
    }
}