package ir.marej.records.parser;

import ir.marej.common.Convert;
import ir.marej.records.model.IPDR;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Component
public class InsertObject {

    @Autowired
    InsertSqlServer insertSqlServer;

    private static final Logger logger = LoggerFactory.getLogger(InsertObject.class);

    public void insertToMysql(File parsedItem) throws IOException {
        Convert convert = new Convert();

        try {
            BufferedReader readfile = Files.newBufferedReader(Paths.get(String.valueOf((parsedItem))));
            String readLines;

            while ((readLines = readfile.readLine()) != null) {

                if (readLines != null) {


                    IPDR ipdr = new IPDR();
                    List<String> records = Arrays.asList(readLines.split("\t"));

                    try {
                        ipdr.setKashef_n(convert.base64(records.get(0)));
                    } catch (Exception e) {
                    }
                    try {
                        ipdr.setSesion_id(records.get(1));
                    } catch (Exception e) {
                    }
                    try {
                        ipdr.setTimestamp(convert.timeConvert(Long.valueOf(records.get(2))));
                    } catch (Exception e) {
                    }
                    try {
                        ipdr.setSource(convert.base64(records.get(4)));
                    } catch (Exception e) {
                        try {

                            String[] tmp3 = records.get(4).split(",", -1);
                            String source = "";
                            for (int i2 = 0; i2 < tmp3.length; i2++) {
                                source += convert.base64(tmp3[i2]) + "|";
                            }

                            ipdr.setSource(source);
                        } catch (Exception e1) {
                            logger.error("base64 error");
                        }

                    }
                    try {
                        ipdr.setType(Integer.parseInt(records.get(5)));
                    } catch (Exception e) {
                    }
                    try {
                        ipdr.setInternate(Integer.parseInt(records.get(6)));
                    } catch (Exception e) {
                    }
                    try {
                        ipdr.setSr_ip(convert.ipConvert(Long.valueOf(records.get(7))));
                    } catch (Exception e) {
                    }
                    try {
                        ipdr.setSr_port(Integer.parseInt(records.get(8)));
                    } catch (Exception e) {
                    }
                    try {
                        ipdr.setDe_ip(convert.ipConvert(Long.valueOf(records.get(9))));
                    } catch (Exception e) {
                    }
                    try {
                        ipdr.setDe_port(Integer.parseInt(records.get(10)));
                    } catch (Exception e) {
                    }
                    try {
                        ipdr.setTr_layer(Integer.parseInt(records.get(11)));
                    } catch (Exception e) {
                    }
                    try {
                        ipdr.setApp_layer((records.get(12)));
                    } catch (Exception e) {
                    }

                    for (int j = 13; j < 54; j++) {
                        j++;
                        try {
                            String str = records.get(j);
                            switch (str) {
                                case "PPP_USERNAME":
                                    try {
                                        ipdr.setPpp_user(convert.base64(records.get(j + 1)));
                                    } catch (Exception e) {
                                    }

                                    break;
                                case "IMSI":
                                    try {
                                        ipdr.setImsi(convert.base64(records.get(j + 1)));
                                    } catch (Exception e) {
                                    }
                                    break;
                                case "IMEI":
                                    try {
                                        ipdr.setImei(convert.base64(records.get(j + 1)));
                                    } catch (Exception e) {
                                    }
                                    break;
                                case "MSISDN":
                                    try {
                                        ipdr.setMsisdn(convert.base64(records.get(j + 1)));
                                    } catch (Exception e) {
                                    }
                                    break;
                                case "RADIUS_USERNAME":
                                    try {
                                        ipdr.setRd_user(convert.base64(records.get(j + 1)));
                                    } catch (Exception e) {
                                    }
                                    break;

                                case "LOCATION_AREA_CODE":
                                    try {
                                        ipdr.setLac(convert.base64(records.get(j + 1)));
                                    } catch (Exception e) {
                                    }
                                    break;
                                case "CELL_IDENTITY":
                                    try {
                                        ipdr.setCell(convert.base64(records.get(j + 1)));
                                    } catch (Exception e) {
                                    }
                                    break;
                                case "SERVICE_AREA_CODE":
                                    try {
                                        ipdr.setSac(convert.base64(records.get(j + 1)));
                                    } catch (Exception e) {
                                    }
                                    break;
                                case "ROUTING_AREA_CODE":
                                    try {
                                        ipdr.setRac(convert.base64(records.get(j + 1)));
                                    } catch (Exception e) {
                                    }
                                    break;
                                case "TRACKING_AREA_CODE":
                                    try {
                                        ipdr.setTac(convert.base64(records.get(j + 1)));
                                    } catch (Exception e) {
                                    }
                                    break;
                                case "E_UTRAN_CELL_IDENTIFIER":
                                    try {
                                        ipdr.setEci(convert.base64(records.get(j + 1)));
                                    } catch (Exception e) {
                                    }
                                    break;
                                case "EVOLVED_NODE_B_IDENTIFIER":
                                    try {
                                        ipdr.setEnb_id(convert.base64(records.get(j + 1)));
                                    } catch (Exception e) {
                                    }
                                    break;
                                case "SOURCE_MPLS_LABEL":
                                    try {
                                        ipdr.setSr_mpls(convert.base64(records.get(j + 1)));
                                    } catch (Exception e) {
                                    }
                                    break;
                                case "DESTINATION_MPLS_LABEL":
                                    try {
                                        ipdr.setSr_mpls(convert.base64(records.get(j + 1)));
                                    } catch (Exception e) {
                                    }
                                    break;
                                case "VLAN_IDENTIFIER":
                                    try {
                                        ipdr.setVlanId(convert.base64(records.get(j + 1)));
                                    } catch (Exception e) {
                                    }
                                    break;
                                case "ACCESS_POINT_NAME":
                                    try {
                                        ipdr.setAccess_point_name(convert.base64(records.get(j + 1)));
                                    } catch (Exception e) {
                                    }
                                    break;
                                case "INTERFACES":
                                    try {
                                        ipdr.setInterfaces(convert.base64(records.get(j + 1)));
                                    } catch (Exception e) {
                                    }
                                    break;
                            }
                        } catch (Exception e) {
                        }
                    }

                    int x = Integer.parseInt(records.get(13));

                    x = (x * 2) + 14;

                    int typ = Integer.parseInt(records.get(5));

                    switch (typ) {
                        case 1:
                            try {
                                insertSqlServer.save(ipdr);
                            } catch (Exception e) {
                            }
                            break;
                        case 2:
                            String[] tmp = readLines.split("\t", -1);
                            String ext = "";
                            for (int i1 = x; i1 < tmp.length; i1++) {
                                ext += convert.base64(tmp[i1]) + "|";
                            }
                            ipdr.setExt1(ext);
                            try {
                                insertSqlServer.save(ipdr);

                            } catch (Exception e) {
                            }

                            break;
                        case 3:
                            String[] tmp1 = readLines.split("\t", -1);
                            String ud = "";
                            for (int i2 = x; i2 < tmp1.length; i2++) {
                                ud += (tmp1[i2]) + "|";
                            }
                            ipdr.setExt1(ud);
                            try {

                                insertSqlServer.save(ipdr);
                            } catch (Exception e) {

                            }

                            break;

                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
