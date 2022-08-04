package dev.pulsarfunction.adsb;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


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
                .add("flight='" + flight.trim() + "'")
                .add("category='" + category + "'")
                .add("emergency='" + emergency + "'")
                .add("mach=" + mach)
                .add("speed=" + speed)
                .add("squawk=" + squawk)
                .add("hex='" + hex + "'")
                .add("altBaro=" + altBaro)
                .add("altGeom=" + altGeom)
                .add("gs=" + gs)
                .add("track=" + track)
                .add("baroRate=" + baroRate)
                .add("navQnh=" + navQnh)
                .add("navAltitudeMcp=" + navAltitudeMcp)
                .add("navHeading=" + navHeading)
                .add("lat=" + lat)
                .add("lon=" + lon)
                .add("nic=" + nic)
                .add("rc=" + rc)
                .add("seenPos=" + seenPos)
                .add("version=" + version)
                .add("nicBaro=" + nicBaro)
                .add("nacP=" + nacP)
                .add("nacV=" + nacV)
                .add("sil=" + sil)
                .add("silType='" + silType + "'")
                .add("gva=" + gva)
                .add("sda=" + sda)
                .add("mlat=" + mlat)
                .add("tisb=" + tisb)
                .add("messages=" + messages)
                .add("seen=" + seen)
                .add("rssi=" + rssi)
                .toString();
    }

    public Aircraft(String flight, String category, String emergency, Double mach, Double speed, Integer squawk, String hex, Integer altBaro, Integer altGeom, Double gs, Double track, Integer baroRate, Double navQnh, Integer navAltitudeMcp, Double navHeading, Double lat, Double lon, Integer nic, Integer rc, Double seenPos, Integer version, Integer nicBaro, Integer nacP, Integer nacV, Integer sil, String silType, Integer gva, Integer sda, List<Object> mlat, List<Object> tisb, Integer messages, Double seen, Double rssi) {
        super();
        this.flight = flight;
        this.category = category;
        this.emergency = emergency;
        this.mach = mach;
        this.speed = speed;
        this.squawk = squawk;
        this.hex = hex;
        this.altBaro = altBaro;
        this.altGeom = altGeom;
        this.gs = gs;
        this.track = track;
        this.baroRate = baroRate;
        this.navQnh = navQnh;
        this.navAltitudeMcp = navAltitudeMcp;
        this.navHeading = navHeading;
        this.lat = lat;
        this.lon = lon;
        this.nic = nic;
        this.rc = rc;
        this.seenPos = seenPos;
        this.version = version;
        this.nicBaro = nicBaro;
        this.nacP = nacP;
        this.nacV = nacV;
        this.sil = sil;
        this.silType = silType;
        this.gva = gva;
        this.sda = sda;
        this.mlat = mlat;
        this.tisb = tisb;
        this.messages = messages;
        this.seen = seen;
        this.rssi = rssi;
    }

    public String getFlight() {
        if (flight !=null) {
            return flight.trim();
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
    private Integer altBaro;
    private Integer altGeom;
    private Double gs;
    private Double track;
    private Integer baroRate;
    private Double navQnh;
    private Integer navAltitudeMcp;
    private Double navHeading;
    private Double lat;
    private Double lon;
    private Integer nic;
    private Integer rc;
    private Double seenPos;
    private Integer version;
    private Integer nicBaro;
    private Integer nacP;
    private Integer nacV;
    private Integer sil;
    private String silType;
    private Integer gva;
    private Integer sda;
    private List<Object> mlat = null;
    private List<Object> tisb = null;
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

    public Integer getAltBaro() {
        return altBaro;
    }

    public void setAltBaro(Integer altBaro) {
        this.altBaro = altBaro;
    }

    public Integer getAltGeom() {
        return altGeom;
    }

    public void setAltGeom(Integer altGeom) {
        this.altGeom = altGeom;
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

    public Integer getBaroRate() {
        return baroRate;
    }

    public void setBaroRate(Integer baroRate) {
        this.baroRate = baroRate;
    }

    public Double getNavQnh() {
        return navQnh;
    }

    public void setNavQnh(Double navQnh) {
        this.navQnh = navQnh;
    }

    public Integer getNavAltitudeMcp() {
        return navAltitudeMcp;
    }

    public void setNavAltitudeMcp(Integer navAltitudeMcp) {
        this.navAltitudeMcp = navAltitudeMcp;
    }

    public Double getNavHeading() {
        return navHeading;
    }

    public void setNavHeading(Double navHeading) {
        this.navHeading = navHeading;
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

    public Double getSeenPos() {
        return seenPos;
    }

    public void setSeenPos(Double seenPos) {
        this.seenPos = seenPos;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getNicBaro() {
        return nicBaro;
    }

    public void setNicBaro(Integer nicBaro) {
        this.nicBaro = nicBaro;
    }

    public Integer getNacP() {
        return nacP;
    }

    public void setNacP(Integer nacP) {
        this.nacP = nacP;
    }

    public Integer getNacV() {
        return nacV;
    }

    public void setNacV(Integer nacV) {
        this.nacV = nacV;
    }

    public Integer getSil() {
        return sil;
    }

    public void setSil(Integer sil) {
        this.sil = sil;
    }

    public String getSilType() {
        return silType;
    }

    public void setSilType(String silType) {
        this.silType = silType;
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

    public List<Object> getMlat() {
        return mlat;
    }

    public void setMlat(List<Object> mlat) {
        this.mlat = mlat;
    }

    public List<Object> getTisb() {
        return tisb;
    }

    public void setTisb(List<Object> tisb) {
        this.tisb = tisb;
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