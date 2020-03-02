package ir.marej.thread;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Broker
{
    private static final Logger logger = LoggerFactory.getLogger(Broker.class);
    public ArrayBlockingQueue<String> queue;
    public Boolean continueProducing;

    public Broker(int... capacity) {
        int queueCapacity = capacity.length > 0 ? capacity[0] : 100;
        this.queue=new ArrayBlockingQueue<String>(queueCapacity);
        this.continueProducing = Boolean.TRUE;
    }

    public void put(String data) throws InterruptedException
    {
        this.queue.put(data);
    }

    public String get() throws InterruptedException
    {
        return this.queue.poll(1, TimeUnit.SECONDS);
    }
}
