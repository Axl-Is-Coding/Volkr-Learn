package io.rong.imlib.statistics;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes5.dex */
public class EventQueue {
    private final StatisticsStore statisticsStore_;

    EventQueue(StatisticsStore statisticsStore) {
        this.statisticsStore_ = statisticsStore;
    }

    String events() {
        List<Event> listEventsList = this.statisticsStore_.eventsList();
        JSONArray jSONArray = new JSONArray();
        Iterator<Event> it = listEventsList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJSON());
        }
        String string = jSONArray.toString();
        this.statisticsStore_.removeEvents(listEventsList);
        try {
            return URLEncoder.encode(string, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return string;
        }
    }

    StatisticsStore getCountlyStore() {
        return this.statisticsStore_;
    }

    void recordEvent(String str, Map<String, String> map, int i, double d2) {
        this.statisticsStore_.addEvent(str, map, Statistics.currentTimestamp(), i, d2);
    }

    int size() {
        return this.statisticsStore_.events().length;
    }
}
