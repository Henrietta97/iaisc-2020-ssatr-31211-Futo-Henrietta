package utililities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import simulator.PetriNet;

import java.io.FileReader;

public class JSONLoader {
    public boolean loadJson(String file) {
        boolean loadStatus = true;
        PetriNet petriNet = PetriNet.getInstance();
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) object;
            JSONObject jsonObjectPN = (JSONObject) jsonObject.get("PN");
            if (jsonObjectPN != null) {
                JSONArray jsonArray = (JSONArray) jsonObjectPN.get("Locations");
                if (jsonArray == null || jsonArray.size() == 0) {
                    throw new Exception("Json error. Location empty");
                } else {
                    for (int i = 0; i < jsonArray.size(); i++) {
                        jsonObject = (JSONObject) jsonArray.get(i);
                        petriNet.addLocation(MappingHandler.jsonObjectToLocation(jsonObject));
                    }
                }
                jsonArray = (JSONArray) jsonObjectPN.get("Transitions");
                if (jsonArray == null || jsonArray.size() == 0) {
                    throw new Exception("Json error. Transitions empty");
                } else {
                    for (int i = 0; i < jsonArray.size(); i++) {
                        jsonObject = (JSONObject) jsonArray.get(i);
                        petriNet.addTransition(MappingHandler.jsonObjectToTransition(jsonObject));
                    }
                }
            } else {
                throw new Exception("Json error. Petri empty");
            }
        } catch (Exception e) {
            loadStatus = false;
            e.printStackTrace();
        }
        return loadStatus;
    }
}
