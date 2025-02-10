package at.htl.counter;

public class TheMain {

    public static void main(String[] args) {
        Thread tick = new Thread(new CounterImp(), "Tick");
        Thread trick = new Thread(new CounterImp(), "Trick");
        Thread track = new Thread(new CounterImp(), "Track");

        tick.start();
        trick.start();
        track.start();
    }
}
