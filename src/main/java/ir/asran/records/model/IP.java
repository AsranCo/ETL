package ir.asran.records.model;


import ir.asran.LoaderApplication;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = IP.table_name)
public class IP {

    public  static final String table_name= LoaderApplication.t_n;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
    @SequenceGenerator(name = "seqGen", sequenceName = "seq", initialValue = 1)
    private long id;
    private Date timestamp;
    private String sr_ip;
    private int sr_port;
    private String de_ip;
    private int de_port;







    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public String getSr_ip() {
        return sr_ip;
    }

    public void setSr_ip(String sr_ip) {
        this.sr_ip = sr_ip;
    }

    public int getSr_port() {
        return sr_port;
    }

    public void setSr_port(int sr_port) {
        this.sr_port = sr_port;
    }

    public String getDe_ip() {
        return de_ip;
    }

    public void setDe_ip(String de_ip) {
        this.de_ip = de_ip;
    }

    public int getDe_port() {
        return de_port;
    }

    public void setDe_port(int de_port) {
        this.de_port = de_port;
    }


    @Override
    public String toString() {
        return "IP{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", sr_ip='" + sr_ip + '\'' +
                ", sr_port=" + sr_port +
                ", de_ip='" + de_ip + '\'' +
                ", de_port=" + de_port +
                '}';
    }
}
