package ir.asran.multiThread;

import ir.asran.records.parser.ParsedItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//@Component
public class ProducerConsumer {
    private static final Logger logger = LoggerFactory.getLogger(ProducerConsumer.class);

    public static void main(int nThreads, int queueSize, String path, ParsedItem insertObject) {
//        while (!Thread.currentThread().isInterrupted()) {

        try {


            Broker broker = new Broker(queueSize);

            //threadPool
            ExecutorService threadPool = Executors.newFixedThreadPool(nThreads + 1);

            //Consumers
            for (int i = 0; i < nThreads; ++i) {
                threadPool.execute(new Consumer("Consumer" + String.valueOf(i + 1), broker, insertObject));
            }


            //Producer
            Future producerStatus = threadPool.submit(new Producer(broker,
                    path));

            // this will wait for the producer to finish its execution.
            producerStatus.get();
            threadPool.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("An InterruptedException was caught: " + e.getMessage());
        }
    }
}
//}
