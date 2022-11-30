package ir.asran;

import ir.asran.records.parser.ParsedItem;
import ir.asran.multiThread.ProducerConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoaderApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(LoaderApplication.class);

    @Autowired
    public ParsedItem readFile;

    public final static String t_n="table_name";

    public static void main(String[] args) {
        SpringApplication.run(LoaderApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        //read props
        int nThreads = Integer.parseInt(String.valueOf(6));
        int queueSize = Integer.parseInt(String.valueOf(1000000));

        String path = "sample/";

        //run loader
        ProducerConsumer.main(nThreads, queueSize, path, readFile);
    }
}