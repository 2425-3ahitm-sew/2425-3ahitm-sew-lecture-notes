package at.htl.counter;

public class CounterImp implements Runnable {

    static int totalCount;
    int maxTotalCount = 100_000;

    @Override
    public void run() {
        int localCount = 0;
        while (totalCount < maxTotalCount) {
            totalCount++;
            localCount++;
        }
        System.out.println(localCount);
    }
}
