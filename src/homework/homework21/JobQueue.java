package homework.homework21;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class JobQueue {
    ArrayList<Callable<Integer>> jobs = new ArrayList<>();

    public synchronized void put(Callable<Integer> job){
        jobs.add(job);
        this.notifyAll();

    }
    public synchronized Callable<Integer> get()throws InterruptedException{
        if (jobs.size() == 0){
            this.wait();
        }
        return jobs.get(0);
    }
}
