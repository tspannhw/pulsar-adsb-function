package dev.pulsarfunction.adsb;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * {"now": 1659642403.8, "messages": 157279, "
 *
 * aircraft": [{"hex": "a55f6c", "alt_baro": 29550, "nav_qnh": 1013.6, "nav_altitude_mcp": 31008, "nav_modes": ["autopilot", "vnav", "tcas"], "version": 0, "nic_baro": 1, "nac_p": 10, "sil": 3, "sil_type": "unknown", "mlat": [], "tisb": [], "messages": 17, "seen": 0.5, "rssi": -25.6}, {"hex": "c051e4", "flight": "ACA099  ", "alt_baro": 39000, "alt_geom": 41125, "gs": 457.6, "track": 15.5, "baro_rate": 0, "squawk": "2266", "emergency": "none", "category": "A5", "nav_qnh": 1012.8, "nav_altitude_mcp": 39008, "lat": 39.901245, "lon": -74.964314, "nic": 8, "rc": 186, "seen_pos": 7.3, "version": 2, "nic_baro": 1, "nac_p": 9, "nac_v": 1, "sil": 3, "sil_type": "perhour", "gva": 2, "sda": 2, "mlat": [], "tisb": [], "messages": 215, "seen": 5.2, "rssi": -24.9},
 *
 *
 */
public class AirCraftParserService {

    /**
     * parse raw NiFi message or Spring message
     *
     * @param message
     * @return Observation
     */
    private List<Aircraft> parseMessage(String message) {
        List<Aircraft> aircraftList = new ArrayList<>();

        if (message == null) {
            return aircraftList;
        }
        try {
            if (message.trim().length() > 0) {
                ObjectMapper mapper = new ObjectMapper();

                JsonNode parent= new ObjectMapper().readTree(message);
                // String messages = parent.path("messages").asText();
                // String now = parent.path("now").asText();

                JsonNode aircraftsNode = parent.path("aircraft");
                if (aircraftsNode != null && aircraftsNode.isArray()) {
                    for (JsonNode node : aircraftsNode) {
                        Aircraft newJsonNode = mapper.treeToValue(node, Aircraft.class);
                        aircraftList.add(newJsonNode);
                        //System.out.println("Node:" + newJsonNode.toString());
                    }
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }

        // if empty
        if (aircraftList == null) {
            aircraftList = new ArrayList<>();
        }
        return aircraftList;
    }

    /**
     * return a clean aircraft
     *byte[]
     * @param input device as a raw string in bytes
     * @return Observation object
     */
    public List<Aircraft> deserialize(String input) {
        if (input == null) {
            return null;
        }
        else {
            return parseMessage(input);
        }
    }
}
