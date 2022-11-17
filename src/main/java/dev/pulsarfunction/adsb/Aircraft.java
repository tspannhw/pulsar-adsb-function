package dev.pulsarfunction.adsb;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Aircraft implements Serializable
{
    /**
     *
     *   hex (String optional)
     *   flight (String optional - name of plane)
     *   alt_baro (int optional - altitude)
     *   alt_geom (int optional)
     *   track (int optional)
     *   baro_rate (int optional)
     *   category (string optional)
     *   nav_qnh (float optional)
     *   nav_altitude_mcp (int optional)
     *   nav_heading (float optional)
     *   nic (int optional)
     *   rc (int optional)
     *   seen_pos (float optional)
     *   version (int optional)
     *   nic_baro (int optional)
     *   nac_p (int optional)
     *   nac_v (int optional)
     *   sil (int optional)
     *   sil_type (string optional)
     *   mlat (array optional)
     *   tisb (array optional)
     *   messages (int optional)
     *   seen (float optional)
     *   rssi (float optional)
     *   squawk (optional) - look at # conversion 7600, 7700, 4000, 5000, 7777, 6100, 5400, 4399, 4478, ...)
     *   speed (optional)
     *   mach (optional speed, mac to mph *767)
     *   emergency (optional string)
     *   lat (long optional)
     *   lon (long optional)
     *
     */

    private String flight;
    private String category;
    private String emergency;
    private Double mach;
    private Double speed;
    private Integer squawk;

    @Override
    public String toString() {
        return new StringJoiner(", ", Aircraft.class.getSimpleName() + "[", "]")
                .add("flight='" + flight + "'")
                .add("category='" + category + "'")
                .add("emergency='" + emergency + "'")
                .add("mach=" + mach)
                .add("speed=" + speed)
                .add("squawk=" + squawk)
                .add("hex='" + hex + "'")
                .add("alt_baro=" + alt_baro)
                .add("alt_geom=" + alt_geom)
                .add("gs=" + gs)
                .add("track=" + track)
                .add("baro_rate=" + baro_rate)
                .add("nav_qnh=" + nav_qnh)
                .add("nav_altitude_mcp=" + nav_altitude_mcp)
                .add("nav_heading=" + nav_heading)
                .add("lat=" + lat)
                .add("lon=" + lon)
                .add("nic=" + nic)
                .add("rc=" + rc)
                .add("seen_post=" + seen_post)
                .add("version=" + version)
                .add("nic_baro=" + nic_baro)
                .add("nac_p=" + nac_p)
                .add("nac_v=" + nac_v)
                .add("sil=" + sil)
                .add("sil_type='" + sil_type + "'")
                .add("gva=" + gva)
                .add("sda=" + sda)
                .add("messages=" + messages)
                .add("seen=" + seen)
                .add("rssi=" + rssi)
                .toString();
    }

    public Aircraft(String flight, String category, String emergency, Double mach, Double speed, Integer squawk, String hex, Integer alt_baro, Integer alt_geom, Double gs, Double track, Integer baro_rate, Double nav_qnh, Integer nav_altitude_mcp, Double nav_heading, Double lat, Double lon, Integer nic, Integer rc, Double seen_post, Integer version, Integer nic_baro, Integer nac_p, Integer nac_v, Integer sil, String sil_type, Integer gva, Integer sda, Integer messages, Double seen, Double rssi) {
        super();
        this.flight = flight;
        this.category = category;
        this.emergency = emergency;
        this.mach = mach;
        this.speed = speed;
        this.squawk = squawk;
        this.hex = hex;
        this.alt_baro = alt_baro;
        this.alt_geom = alt_geom;
        this.gs = gs;
        this.track = track;
        this.baro_rate = baro_rate;
        this.nav_qnh = nav_qnh;
        this.nav_altitude_mcp = nav_altitude_mcp;
        this.nav_heading = nav_heading;
        this.lat = lat;
        this.lon = lon;
        this.nic = nic;
        this.rc = rc;
        this.seen_post = seen_post;
        this.version = version;
        this.nic_baro = nic_baro;
        this.nac_p = nac_p;
        this.nac_v = nac_v;
        this.sil = sil;
        this.sil_type = sil_type;
        this.gva = gva;
        this.sda = sda;
        this.messages = messages;
        this.seen = seen;
        this.rssi = rssi;
    }

    public String getFlight() {
        if (this.flight != null) {
            return this.flight.trim();
        }
        else {
            return null;
        }
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }

    public Double getMach() {
        return mach;
    }

    public void setMach(Double mach) {
        this.mach = mach;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getSquawk() {
        return squawk;
    }

    public void setSquawk(Integer squawk) {
        this.squawk = squawk;
    }

    private String hex;
    @JsonProperty("alt_baro")
    private Integer alt_baro;
    @JsonProperty("alt_geom")
    private Integer alt_geom;
    private Double gs;
    private Double track;
    @JsonProperty("baro_rate")
    private Integer baro_rate;
    @JsonProperty("nav_qnh")
    private Double nav_qnh;
    @JsonProperty("nav_altitude_mcp")
    private Integer nav_altitude_mcp;
    @JsonProperty("nav_heading")
    private Double nav_heading;
    private Double lat;
    private Double lon;
    private Integer nic;
    private Integer rc;
    @JsonProperty("seen_post")
    private Double seen_post;
    private Integer version;
    @JsonProperty("nic_baro")
    private Integer nic_baro;
    @JsonProperty("nac_p")
    private Integer nac_p;
    @JsonProperty("nac_v")
    private Integer nac_v;
    private Integer sil;
    @JsonProperty("sil_type")
    private String sil_type;
    private Integer gva;
    private Integer sda;
//    private List<Object> mlat = null;
//    private List<Object> tisb = null;
    private Integer messages;
    private Double seen;
    private Double rssi;
    private final static long serialVersionUID = 665418074644696413L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Aircraft() {
        super();
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public Integer getAlt_baro() {
        return alt_baro;
    }

    public void setAlt_baro(Integer alt_baro) {
        this.alt_baro = alt_baro;
    }

    public Integer getAlt_geom() {
        return alt_geom;
    }

    public void setAlt_geom(Integer alt_geom) {
        this.alt_geom = alt_geom;
    }

    public Double getGs() {
        return gs;
    }

    public void setGs(Double gs) {
        this.gs = gs;
    }

    public Double getTrack() {
        return track;
    }

    public void setTrack(Double track) {
        this.track = track;
    }

    public Integer getBaro_rate() {
        return baro_rate;
    }

    public void setBaro_rate(Integer baro_rate) {
        this.baro_rate = baro_rate;
    }

    public Double getNav_qnh() {
        return nav_qnh;
    }

    public void setNav_qnh(Double nav_qnh) {
        this.nav_qnh = nav_qnh;
    }

    public Integer getNav_altitude_mcp() {
        return nav_altitude_mcp;
    }

    public void setNav_altitude_mcp(Integer nav_altitude_mcp) {
        this.nav_altitude_mcp = nav_altitude_mcp;
    }

    public Double getNav_heading() {
        return nav_heading;
    }

    public void setNav_heading(Double nav_heading) {
        this.nav_heading = nav_heading;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Integer getNic() {
        return nic;
    }

    public void setNic(Integer nic) {
        this.nic = nic;
    }

    public Integer getRc() {
        return rc;
    }

    public void setRc(Integer rc) {
        this.rc = rc;
    }

    public Double getSeen_post() {
        return seen_post;
    }

    public void setSeen_post(Double seen_post) {
        this.seen_post = seen_post;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getNic_baro() {
        return nic_baro;
    }

    public void setNic_baro(Integer nic_baro) {
        this.nic_baro = nic_baro;
    }

    public Integer getNac_p() {
        return nac_p;
    }

    public void setNac_p(Integer nac_p) {
        this.nac_p = nac_p;
    }

    public Integer getNac_v() {
        return nac_v;
    }

    public void setNac_v(Integer nac_v) {
        this.nac_v = nac_v;
    }

    public Integer getSil() {
        return sil;
    }

    public void setSil(Integer sil) {
        this.sil = sil;
    }

    public String getSil_type() {
        return sil_type;
    }

    public void setSil_type(String sil_type) {
        this.sil_type = sil_type;
    }

    public Integer getGva() {
        return gva;
    }

    public void setGva(Integer gva) {
        this.gva = gva;
    }

    public Integer getSda() {
        return sda;
    }

    public void setSda(Integer sda) {
        this.sda = sda;
    }

    public Integer getMessages() {
        return messages;
    }

    public void setMessages(Integer messages) {
        this.messages = messages;
    }

    public Double getSeen() {
        return seen;
    }

    public void setSeen(Double seen) {
        this.seen = seen;
    }

    public Double getRssi() {
        return rssi;
    }

    public void setRssi(Double rssi) {
        this.rssi = rssi;
    }


}