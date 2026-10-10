package com.unity3d.services.monetization.core.utilities;

import com.unity3d.services.core.log.DeviceLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class JSONUtilities {
    public static List<Object> jsonArrayToList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(mapTypeFromJSON(jSONArray.get(i)));
            } catch (JSONException e2) {
                DeviceLog.error("Could not put value into list: %s", e2.getMessage());
            }
        }
        return arrayList;
    }

    public static Map<String, Object> jsonObjectToMap(JSONObject jSONObject) {
        HashMap map = new HashMap(jSONObject.length());
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                map.put(next, mapTypeFromJSON(jSONObject.get(next)));
            } catch (JSONException e2) {
                DeviceLog.error("Could not put value in map: %s, %s", next, e2.getMessage());
            }
        }
        return map;
    }

    public static JSONObject mapToJsonObject(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), wrap(entry.getValue()));
            } catch (JSONException unused) {
                DeviceLog.error("Could not map entry to object: %s, %s", entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    private static Object mapTypeFromJSON(Object obj) {
        return obj instanceof JSONObject ? jsonObjectToMap((JSONObject) obj) : obj instanceof JSONArray ? jsonArrayToList((JSONArray) obj) : obj;
    }

    public static Object wrap(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(JSONObject.NULL)) {
            return obj;
        }
        if (obj instanceof Collection) {
            return new JSONArray((Collection) obj);
        }
        if (obj.getClass().isArray()) {
            return new JSONArray((Collection) Arrays.asList(obj));
        }
        if (obj instanceof Map) {
            return new JSONObject((Map) obj);
        }
        if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof String)) {
            if (obj instanceof Enum) {
                return obj.toString();
            }
            if (obj.getClass().getPackage().getName().startsWith("java.")) {
                return obj.toString();
            }
            return null;
        }
        return obj;
    }
}
