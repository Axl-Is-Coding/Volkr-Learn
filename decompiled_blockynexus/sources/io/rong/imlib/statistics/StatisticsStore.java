package io.rong.imlib.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class StatisticsStore {
    private static final String CONNECTIONS_PREFERENCE = "CONNECTIONS";
    private static final String DELIMITER = ":::";
    private static final String EVENTS_PREFERENCE = "EVENTS";
    private static final String LATEST_UPLOAD = "LATEST";
    private static final String LOCATION_PREFERENCE = "LOCATION";
    private static final String PREFERENCES = "COUNTLY_STORE";
    private static final int UPLOAD_DURATION = 86400;
    private final SharedPreferences preferences_;

    StatisticsStore(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("must provide valid context");
        }
        this.preferences_ = context.getSharedPreferences(PREFERENCES, 0);
    }

    static String join(Collection<String> collection, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            sb.append(it.next());
            i++;
            if (i < collection.size()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    static String joinEvents(Collection<Event> collection, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<Event> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toJSON().toString());
        }
        return join(arrayList, str);
    }

    public synchronized void addConnection(String str) {
        if (str != null) {
            if (str.length() > 0) {
                ArrayList arrayList = new ArrayList(Arrays.asList(connections()));
                arrayList.add(str);
                this.preferences_.edit().putString(CONNECTIONS_PREFERENCE, join(arrayList, DELIMITER)).commit();
            }
        }
    }

    void addEvent(Event event) {
        List<Event> listEventsList = eventsList();
        listEventsList.add(event);
        this.preferences_.edit().putString(EVENTS_PREFERENCE, joinEvents(listEventsList, DELIMITER)).commit();
    }

    synchronized void clear() {
        SharedPreferences.Editor editorEdit = this.preferences_.edit();
        editorEdit.remove(EVENTS_PREFERENCE);
        editorEdit.remove(CONNECTIONS_PREFERENCE);
        editorEdit.commit();
    }

    public String[] connections() {
        String string = this.preferences_.getString(CONNECTIONS_PREFERENCE, "");
        return string.length() == 0 ? new String[0] : string.split(DELIMITER);
    }

    public String[] events() {
        String string = this.preferences_.getString(EVENTS_PREFERENCE, "");
        return string.length() == 0 ? new String[0] : string.split(DELIMITER);
    }

    public List<Event> eventsList() {
        String[] strArrEvents = events();
        ArrayList arrayList = new ArrayList(strArrEvents.length);
        for (String str : strArrEvents) {
            try {
                Event eventFromJSON = Event.fromJSON(new JSONObject(str));
                if (eventFromJSON != null) {
                    arrayList.add(eventFromJSON);
                }
            } catch (JSONException unused) {
            }
        }
        Collections.sort(arrayList, new Comparator<Event>() { // from class: io.rong.imlib.statistics.StatisticsStore.1
            @Override // java.util.Comparator
            public int compare(Event event, Event event2) {
                return event.timestamp - event2.timestamp;
            }
        });
        return arrayList;
    }

    String getAndRemoveLocation() {
        String string = this.preferences_.getString("LOCATION", "");
        if (!string.equals("")) {
            this.preferences_.edit().remove("LOCATION").commit();
        }
        return string;
    }

    public synchronized String getPreference(String str) {
        return this.preferences_.getString(str, null);
    }

    public boolean isEmptyConnections() {
        return this.preferences_.getString(CONNECTIONS_PREFERENCE, "").length() == 0;
    }

    public synchronized void removeConnection(String str) {
        if (str != null) {
            if (str.length() > 0) {
                ArrayList arrayList = new ArrayList(Arrays.asList(connections()));
                if (arrayList.remove(str)) {
                    this.preferences_.edit().putString(CONNECTIONS_PREFERENCE, join(arrayList, DELIMITER)).commit();
                }
            }
        }
    }

    public synchronized void removeEvents(Collection<Event> collection) {
        if (collection != null) {
            if (collection.size() > 0) {
                List<Event> listEventsList = eventsList();
                if (listEventsList.removeAll(collection)) {
                    this.preferences_.edit().putString(EVENTS_PREFERENCE, joinEvents(listEventsList, DELIMITER)).commit();
                }
            }
        }
    }

    void setLocation(double d2, double d3) {
        this.preferences_.edit().putString("LOCATION", d2 + "," + d3).commit();
    }

    public synchronized void setPreference(String str, String str2) {
        if (str2 == null) {
            this.preferences_.edit().remove(str).commit();
        } else {
            this.preferences_.edit().putString(str, str2).commit();
        }
    }

    public void updateLatestUploadTime() {
        this.preferences_.edit().putInt(LATEST_UPLOAD, Statistics.currentTimestamp()).commit();
    }

    public boolean uploadIfNeed() {
        int iCurrentTimestamp = Statistics.currentTimestamp();
        int i = this.preferences_.getInt(LATEST_UPLOAD, 0);
        if (Statistics.sharedInstance().isLoggingEnabled()) {
            Log.w("Statistics", "uploadIfNeed : last = " + i + ", current = " + iCurrentTimestamp);
        }
        if (i == 0) {
            updateLatestUploadTime();
            return true;
        }
        if (i + UPLOAD_DURATION > iCurrentTimestamp) {
            return false;
        }
        updateLatestUploadTime();
        return true;
    }

    public synchronized void addEvent(String str, Map<String, String> map, int i, int i2, double d2) {
        Event event = new Event();
        event.key = str;
        event.segmentation = map;
        event.timestamp = i;
        event.count = i2;
        event.sum = d2;
        addEvent(event);
    }
}
