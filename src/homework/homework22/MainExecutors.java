package homework.homework22;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class MainExecutors {
    private static int COUNT = 0;


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<Integer>> arr = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            arr.add(executor.submit(new Count()));
        }
        executor.shutdown();
        for (Future<Integer> ex : arr) {
            COUNT += ex.get();
        }

        System.out.println(COUNT);
    }

    public static Integer counter(Integer plusOne) {
        return ++plusOne;
    }

    public static class Count implements Callable<Integer> {

        @Override
        public Integer call() {

            Integer buff = 0;
            for (int i = 0; i < 1000; i++) {
                buff = counter(buff);
            }
            System.out.println(Thread.currentThread().getName());
            return buff;
        }
    }
}
