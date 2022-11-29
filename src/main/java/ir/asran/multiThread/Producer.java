package ir.asran.multiThread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Producer implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private Broker broker;
    private String dirPath;

    public Producer() {
    }

    public Producer(Broker broker, String dirPath) {
        this.broker = broker;
        this.dirPath = dirPath;
    }


    @Override
    public void run() {

        try (Stream<Path> walk = Files.walk(Paths.get(dirPath))) {

            List<String> listFiles = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString())
//                    .filter(p -> p.toString().endsWith(".csv"))
                    .filter(p -> !p.toString().endsWith(".gz"))
                    .filter(p -> !p.toString().contains(".processing"))
                    .filter(p -> !p.toString().contains(".processed"))
                    .filter(p -> !p.toString().startsWith("."))
                    .collect(Collectors.toList());

            for (String filePath : listFiles) {
                File file = new File(filePath);

                File processingFile = new File(filePath + ".processing");// rename to indicate that processing file
                File processedFile = new File(filePath + ".processed");// rename to indicate that processed file
                File zipdFile = new File(filePath + ".gz");// rename to indicate that processed file

                if (!processingFile.exists() && !processedFile.exists()
                        && !filePath.endsWith(".processing") && !filePath.endsWith(".gz") && !filePath.endsWith(".processed")) {

                    if (file.renameTo(processingFile)) {//if renamed successfully

                        logger.info(processingFile.getAbsolutePath());
                        try {
                            BufferedReader reader = Files.newBufferedReader(Paths.get(processingFile.getAbsolutePath()));
                            String line;
                            while ((line = reader.readLine()) != null) {
                                if (line != null) {

                                    //Todo insert line on ring
                                    try {
                                        broker.put(line);
                                    } catch (Exception r) {
                                    }
                                }
                            }


                            processingFile.renameTo(processedFile);

                        } catch (IOException e) {
                            e.printStackTrace();
                            logger.error(e.getMessage());
                        }
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error to read file ");
        }
        this.broker.continueProducing = Boolean.FALSE;
//        logger.info("Producer finished its job; terminating.");
    }
}
