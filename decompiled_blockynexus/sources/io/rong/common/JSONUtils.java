package io.rong.common;

import android.text.TextUtils;
import io.rong.imlib.model.MessageExpansion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class JSONUtils {
    private static final String TAG = "JSONUtils";

    public static String exMapToJson(HashMap<String, MessageExpansion> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, MessageExpansion> entry : map.entrySet()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("v", entry.getValue().getValue());
                jSONObject2.put("ts", entry.getValue().getTs());
                jSONObject.put(entry.getKey().toString(), jSONObject2);
            } catch (JSONException e2) {
                RLog.e(TAG, "exMapToJson " + e2.toString());
                return "";
            }
        }
        return jSONObject.toString();
    }

    public static HashMap<String, String> expansionExJSONToMap(String str) {
        HashMap<String, String> map = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            return map;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, new JSONObject(jSONObject.get(next).toString()).optString("v").toString());
            }
            return map;
        } catch (JSONException e2) {
            RLog.e(TAG, "expansionExJSONToMap " + e2.toString());
            return map;
        }
    }

    public static HashMap<String, String> expansionExToMap(Map<String, MessageExpansion> map) {
        HashMap<String, String> map2 = new HashMap<>();
        if (map == null || map.size() == 0) {
            return null;
        }
        for (Map.Entry<String, MessageExpansion> entry : map.entrySet()) {
            map2.put(entry.getKey().toString(), entry.getValue().getValue());
        }
        return map2;
    }

    public static String hashMapToJson(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || map.size() == 0) {
            return "";
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("v", entry.getValue());
                jSONObject.put(entry.getKey(), jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public static HashMap<String, MessageExpansion> jsonToExpansionEx(String str) {
        HashMap<String, MessageExpansion> map = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            return map;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObject2 = new JSONObject(jSONObject.get(next).toString());
                map.put(next, new MessageExpansion(jSONObject2.optString("v"), jSONObject2.optLong("ts")));
            }
        } catch (JSONException e2) {
            RLog.e(TAG, "jsonToExpansionEx " + e2.toString());
        }
        return map;
    }

    public static String mapTsCombineJson(Map<String, String> map, long j) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || map.size() == 0) {
            return "";
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("v", entry.getValue());
                jSONObject2.put("ts", j);
                jSONObject.put(entry.getKey().toString(), jSONObject2);
            } catch (JSONException unused) {
                RLog.e(TAG, "mapTsCombineJson " + entry.toString());
            }
        }
        return jSONObject.toString();
    }

    public static List<String> mergeJson(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            if (TextUtils.isEmpty(str)) {
                arrayList.add(str2);
                arrayList.add("");
                return arrayList;
            }
            if (TextUtils.isEmpty(str2)) {
                arrayList.add(str);
                arrayList.add(str);
                return arrayList;
            }
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            JSONObject jSONObject3 = new JSONObject();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                if (jSONObject2.has(next)) {
                    if (new JSONObject(obj.toString()).optLong("ts") > new JSONObject(jSONObject2.get(next).toString()).optLong("ts")) {
                        jSONObject2.put(next, obj);
                        jSONObject3.put(next, obj);
                    }
                } else {
                    jSONObject2.put(next, obj);
                    jSONObject3.put(next, obj);
                }
            }
            arrayList.add(jSONObject2.toString());
            arrayList.add(jSONObject3.toString());
            return arrayList;
        } catch (JSONException e2) {
            RLog.e(TAG, "mergeJson " + e2.toString());
            return null;
        }
    }

    public static List<Object> removeKeysInExpansionEx(List<String> list, HashMap<String, MessageExpansion> map) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list == null || list.size() == 0) {
            if (map != null) {
                arrayList2.addAll(map.keySet());
                map.clear();
            }
            arrayList.add(map);
            arrayList.add(arrayList2);
            return arrayList;
        }
        for (String str : list) {
            if (map == null) {
                break;
            }
            if (map.containsKey(str)) {
                arrayList2.add(str);
            }
            map.remove(str);
        }
        arrayList.add(map);
        arrayList.add(arrayList2);
        return arrayList;
    }

    public static List<Object> removeKeysTSInExpansionEx(long j, List<String> list, HashMap<String, MessageExpansion> map) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list == null || list.size() == 0) {
            if (map != null) {
                for (String str : map.keySet()) {
                    MessageExpansion messageExpansion = map.get(str);
                    if (messageExpansion != null && j > messageExpansion.getTs()) {
                        map.remove(str);
                        arrayList2.add(str);
                    }
                }
            }
            arrayList.add(map);
            arrayList.add(arrayList2);
            return arrayList;
        }
        for (String str2 : list) {
            if (map == null) {
                break;
            }
            MessageExpansion messageExpansion2 = map.get(str2);
            if (messageExpansion2 != null && j > messageExpansion2.getTs()) {
                map.remove(str2);
                arrayList2.add(str2);
            }
        }
        arrayList.add(map);
        arrayList.add(arrayList2);
        return arrayList;
    }
}
