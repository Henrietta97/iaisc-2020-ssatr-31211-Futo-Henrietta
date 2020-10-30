package utililities;

import models.Location;
import models.Transition;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MappingHandler {
    public static Location jsonObjectToLocation(JSONObject jsonObject) throws Exception {
        Location location = new Location();
        try {
            location.setId(jsonObject.get("id").toString());
            location.setTokens(Integer.parseInt(jsonObject.get("tokens").toString()));

            JSONArray jsonArray = (JSONArray) jsonObject.get("input");
            List<String> inoutList = new ArrayList<String>();
            Iterator<String> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                inoutList.add(iterator.next());
            }
            location.setInput(inoutList);

            jsonArray = (JSONArray) jsonObject.get("output");
            inoutList = new ArrayList<String>();
            iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                inoutList.add(iterator.next());
            }
            location.setOutput(inoutList);
        } catch (Exception e) {
            throw new Exception("JSON error. Locations mapping");
        }
        return location;
    }

    public static Transition jsonObjectToTransition(JSONObject jsonObject) throws Exception {
        Transition transition = new Transition();
        try {
            transition.setId(jsonObject.get("id").toString());
            transition.setMinTime(Integer.parseInt(jsonObject.get("minTime").toString()));
            transition.setMaxTime(Integer.parseInt(jsonObject.get("maxTime").toString()));

            JSONArray jsonArray = (JSONArray) jsonObject.get("input");
            List<String> inoutList = new ArrayList<String>();
            Iterator<String> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                inoutList.add(iterator.next());
            }
            transition.setInput(inoutList);

            jsonArray = (JSONArray) jsonObject.get("output");
            inoutList = new ArrayList<String>();
            iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                inoutList.add(iterator.next());
            }
            transition.setOutput(inoutList);
        } catch (Exception e) {
            throw new Exception("JSON error. Transition mapping");
        }
        return transition;
    }
}
