package ir.marej.thread;

import ir.marej.records.parser.InsertObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

//@Component
public class Consumer implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    public InsertObject insertObject;


    private String name;
    private Broker broker;

    public Consumer(String name, Broker broker, InsertObject insertObject) {
        this.name = name;
        this.broker = broker;
        this.insertObject = insertObject;
    }


    @Override
    public void run() {
        try {
            String data = broker.get();

            while (broker.continueProducing || data != null) {

                try {
                    if (data != null) {
                        File file = new File(data);
                        File processingFile = new File(data + ".processing");// rename to indicate that processing file
                        File processedFile = new File(data + ".processed");// rename to indicate that processed file

                        if (!processingFile.exists() && !processedFile.exists()
                                && !data.endsWith(".processing") && !data.endsWith(".processed")) {

                            if (file.renameTo(processingFile)) {//if renamed successfully
                                logger.info(processingFile.getAbsolutePath());

                                try {
                                    insertObject.insertToMysql(processingFile);

                                } catch (Exception e) {
                                    e.printStackTrace();
                                    logger.error(e.getMessage());
                                }
                            }

                            //finished reading a file
                            processingFile.renameTo(processedFile);
                            // processingFile.delete();// delete .processing file
                        }

                    } else {
                        logger.warn("this file is processed by other Consumer: " + data);
                    }

                } catch (
                        Exception ex) {
                    logger.error("Error to processing file " + "|||||||||" + data + "|||||||||" + ex.getMessage());
                }


                data = broker.get();
            }


            logger.info("Consumer " + this.name + " finished its job; terminating.");
        } catch (
                InterruptedException ex) {
            ex.printStackTrace();
        }
    }


}
