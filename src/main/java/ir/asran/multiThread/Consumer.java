package ir.asran.multiThread;

import ir.asran.records.parser.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@Component
public class Consumer implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    public Record insertObject;


    private String name;
    private Broker broker;

    public Consumer(String name, Broker broker, Record insertObject) {
        this.name = name;
        this.broker = broker;
        this.insertObject = insertObject;
    }


    @Override
    public void run() {
        String bulksize = "2000";
        try {
            String data = broker.get();
            List<String> list = new ArrayList<>();

            while (broker.continueProducing || data != null) {
                for (int i = 1; i <= Integer.parseInt(bulksize); i++) {
                    try {
                        if (data != null) {
                            list.add(data);
                        }
                    } catch (Exception ex) {
                        logger.error("خطای پردازش رکورد" + "|||||||||" + data + "|||||||||" + ex.getMessage());
                    }
                    data = broker.get();
                    if (data == null) {
                        i = Integer.parseInt(bulksize);
                    }
                }
                insertObject.insertToMysql(list);
                list.clear();
            }

        } catch (InterruptedException | IOException ex) {
            ex.printStackTrace();
        }
    }

}