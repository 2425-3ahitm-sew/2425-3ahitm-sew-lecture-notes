package at.htl.counter;

public class CounterImp implements Runnable {

    static int totalCount;
    int maxTotalCount = 100_000;

    @Override
    public synchronized void run() {
        int localCount = 0;
        while (totalCount < maxTotalCount) {
            totalCount++;
            localCount++;
        }
        System.out.printf("%s: %d/%d%n",Thread.currentThread().getName(),localCount, maxTotalCount);
    }
}
