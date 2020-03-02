package ir.marej.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Convert {

    public String base64(String code) {
        if (!code.isEmpty() && code != null) {
            return new String(Base64.getDecoder().decode(code));
        } else
            return "";
    }

    public String ipConvert(Long ip) {
        String srcIp;
        srcIp = (ip & 0XFF) + "." + ((ip >> 8) & 0XFF) + "." + ((ip >> 16) & 0XFF) + "." + ((ip >> 24) & 0XFF);
        return srcIp;
    }

    public Date timeConvert(Long time) throws Exception {

        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss aa");
        String vdate = simpleDateFormat.format((time*1000));
        Date date = simpleDateFormat.parse(vdate);


        return date;
    }
}
