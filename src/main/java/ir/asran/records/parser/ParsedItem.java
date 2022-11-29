package ir.asran.records.parser;

import ir.asran.common.Convert;
import ir.asran.records.model.IP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class ParsedItem {

    @Autowired
    ParsedItemRepository insertSqlServer;

    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")

    private static final Logger logger = LoggerFactory.getLogger(ParsedItem.class);

    public void insertToMysql(List parsedItem) throws IOException {
        Convert convert = new Convert();

        try {


            for (int i = 0; i < parsedItem.size(); i++) {

                String readLines = (String) parsedItem.get(i);

                IP ip = new IP();
                List<String> records = Arrays.asList(readLines.split("\t"));

                try {
                    ip.setTimestamp(convert.timeConvert(Long.valueOf(records.get(2))));
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    ip.setSr_ip(convert.ipConvert(Long.valueOf(records.get(7))));
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    ip.setSr_port(Integer.parseInt(records.get(8)));
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    ip.setDe_ip(convert.ipConvert(Long.valueOf(records.get(9))));
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    ip.setDe_port(Integer.parseInt(records.get(10)));
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }


                try {
                    insertSqlServer.save(ip);
                } catch (Exception e) {
                    logger.error("Error load record on sql server --> " + e.getMessage());
                }
            }
        } catch (
                Exception e) {
            logger.error(e.getMessage());

        }
    }
}
