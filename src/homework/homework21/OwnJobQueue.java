package homework.homework21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class OwnJobQueue {

    static final JobQueue jobQueue = new JobQueue();
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        int count = 0;


        List<Future<Integer>> arr = new ArrayList<>();
        String task;

        for (int j = 0; j < 100; j++) {
            arr.add(executorService.submit(jobQueue.get()));
        }
        for (int i = 0; i < 1000; i++) {
            jobQueue.put(new PerformanceJob());
        }


        for (Future<Integer> ex : arr) {
            count += ex.get();
        }
        System.out.println(count);
        executorService.shutdown();
    }


//    private static void jobPut() throws IOException {
//
//        System.out.print("Сколько заданий добавить: ");
//        int amount = Integer.parseInt(reader.readLine());
//
//        for (int i = 0; i < amount; i++) {
//            jobQueue.put(new PerformanceJob());
//        }
//        jobGet();
//    }
//
//    private static void jobGet(List<Future<Integer>> arr) throws IOException, InterruptedException {
//
//
//        System.out.println("Сколько заданий выполнить: ");
//        int amount = Integer.parseInt(reader.readLine());
//
//        for (int j = 0; j < amount; j++) {
//            arr.add(executorService.submit(jobQueue.get()));
//        }
//
//    }

    public static class PerformanceJob implements Callable<Integer> {


        @Override
        public Integer call() throws Exception {

            int buff = 0;
            System.out.println(Thread.currentThread().getName());

            return buff + 100;
        }
    }
}



