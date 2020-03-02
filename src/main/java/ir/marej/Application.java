package ir.marej;

import ir.marej.records.parser.InsertObject;
import ir.marej.thread.ProducerConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    public static String address;

    @Autowired
    public InsertObject readFile;
    public static void main(String[] args) {
        SpringApplication.run(Application.class);


//        address=args[0];
        }


        @Override
        public void run(String... args) throws Exception {





        //read props
        int nThreads = Integer.parseInt(String.valueOf(50));
        int queueSize = Integer.parseInt(String.valueOf(1000));
        String path = "/mnt/data/Filter/new";
//        String path = "/home/ali/Template/target/total/";


        long startTime = System.currentTimeMillis();

        //run loader

        ProducerConsumer.main(nThreads, queueSize, path,readFile);

        long stopTime = System.currentTimeMillis();

    }

}


