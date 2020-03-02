package ir.marej.records.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Filter_tbl")
//@Table(name = "debug_tbl")
public class IPDR {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String kashef_n;
    private String sesion_id;
    private Date timestamp;
    private String source;
    private int type;
    private int internate;
    private String sr_ip;
    private int sr_port;
    private String de_ip;
    private int de_port;
    private int tr_layer;
    private String app_layer;
    private String ppp_user;
    private String imsi;
    private String imei;
    private String msisdn;
    private String rd_user;
    private String lac;
    private String cell;
    private String sac;
    private String rac;
    private String tac;
    private String enb_id;
    private String sr_mpls;
    private String de_mpls;
    private String vlanId;
    private String eci;
    private String access_point_name;
    private String interfaces;
    @Lob
    @Column
    private String ext1;




    public String getAccess_point_name() {
        return access_point_name;
    }

    public void setAccess_point_name(String access_point_name) {
        this.access_point_name = access_point_name;
    }

    public String getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(String interfaces) {
        this.interfaces = interfaces;
    }


    String getSr_mpls() {
        return sr_mpls;
    }

    public void setSr_mpls(String sr_mpls) {
        this.sr_mpls = sr_mpls;
    }

    public String getDe_mpls() {
        return de_mpls;
    }

    public void setDe_mpls(String de_mpls) {
        this.de_mpls = de_mpls;
    }

    public String getVlanId() {
        return vlanId;
    }

    public void setVlanId(String vlanId) {
        this.vlanId = vlanId;
    }


    public String getKashef_n() {
        return kashef_n;
    }

    public void setKashef_n(String kashef_n) {
        this.kashef_n = kashef_n;
    }

    public String getSesion_id() {
        return sesion_id;
    }

    public void setSesion_id(String sesion_id) {
        this.sesion_id = sesion_id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getInternate() {
        return internate;
    }

    public void setInternate(int internate) {
        this.internate = internate;
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

    public int getTr_layer() {
        return tr_layer;
    }

    public void setTr_layer(int tr_layer) {
        this.tr_layer = tr_layer;
    }

    public String getApp_layer() {
        return app_layer;
    }

    public void setApp_layer(String app_layer) {
        this.app_layer = app_layer;
    }

    public String getPpp_user() {
        return ppp_user;
    }

    public void setPpp_user(String ppp_user) {
        this.ppp_user = ppp_user;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getRd_user() {
        return rd_user;
    }

    public void setRd_user(String rd_user) {
        this.rd_user = rd_user;
    }

    public String getLac() {
        return lac;
    }

    public void setLac(String lac) {
        this.lac = lac;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getSac() {
        return sac;
    }

    public void setSac(String sac) {
        this.sac = sac;
    }

    public String getRac() {
        return rac;
    }

    public void setRac(String rac) {
        this.rac = rac;
    }

    public String getTac() {
        return tac;
    }

    public void setTac(String tac) {
        this.tac = tac;
    }

    public String getEnb_id() {
        return enb_id;
    }

    public void setEnb_id(String enb_id) {
        this.enb_id = enb_id;
    }

    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }


}
