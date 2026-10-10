package io.rong.imlib.statistics;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
class Event {
    private static final String COUNT_KEY = "count";
    private static final String KEY_KEY = "key";
    private static final String SEGMENTATION_KEY = "segmentation";
    private static final String SUM_KEY = "sum";
    private static final String TIMESTAMP_KEY = "timestamp";
    public int count;
    public String key;
    public Map<String, String> segmentation;
    public double sum;
    public int timestamp;

    Event() {
    }

    static Event fromJSON(JSONObject jSONObject) {
        String str;
        Event event = new Event();
        try {
            if (!jSONObject.isNull(KEY_KEY)) {
                event.key = jSONObject.getString(KEY_KEY);
            }
            event.count = jSONObject.optInt(COUNT_KEY);
            event.sum = jSONObject.optDouble(SUM_KEY, 0.0d);
            event.timestamp = jSONObject.optInt(TIMESTAMP_KEY);
            if (!jSONObject.isNull(SEGMENTATION_KEY)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(SEGMENTATION_KEY);
                HashMap map = new HashMap(jSONObject2.length());
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!jSONObject2.isNull(next)) {
                        map.put(next, jSONObject2.getString(next));
                    }
                }
                event.segmentation = map;
            }
        } catch (JSONException e2) {
            if (Statistics.sharedInstance().isLoggingEnabled()) {
                Log.w("Statistics", "Got exception converting JSON to an Event", e2);
            }
            event = null;
        }
        if (event == null || (str = event.key) == null || str.length() <= 0) {
            return null;
        }
        return event;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        String str = this.key;
        if (str == null) {
            if (event.key != null) {
                return false;
            }
        } else if (!str.equals(event.key)) {
            return false;
        }
        if (this.timestamp != event.timestamp) {
            return false;
        }
        Map<String, String> map = this.segmentation;
        if (map == null) {
            if (event.segmentation != null) {
                return false;
            }
        } else if (!map.equals(event.segmentation)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.key;
        int iHashCode = str != null ? str.hashCode() : 1;
        Map<String, String> map = this.segmentation;
        int iHashCode2 = iHashCode ^ (map != null ? map.hashCode() : 1);
        int i = this.timestamp;
        return iHashCode2 ^ (i != 0 ? i : 1);
    }

    JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_KEY, this.key);
            jSONObject.put(COUNT_KEY, this.count);
            jSONObject.put(TIMESTAMP_KEY, this.timestamp);
            if (this.segmentation != null) {
                jSONObject.put(SEGMENTATION_KEY, new JSONObject(this.segmentation));
            }
            jSONObject.put(SUM_KEY, this.sum);
        } catch (JSONException e2) {
            if (Statistics.sharedInstance().isLoggingEnabled()) {
                Log.w("Statistics", "Got exception converting an Event to JSON", e2);
            }
        }
        return jSONObject;
    }
}
