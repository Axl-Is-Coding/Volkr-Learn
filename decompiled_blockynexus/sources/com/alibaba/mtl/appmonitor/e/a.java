package com.alibaba.mtl.appmonitor.e;

import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.t;
import com.alibaba.mtl.log.model.LogField;
import java.util.Map;

/* JADX INFO: compiled from: UTAggregationPlugin.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f3591a;

    private a() {
    }

    public static synchronized a a() {
        if (f3591a == null) {
            f3591a = new a();
        }
        return f3591a;
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        i.a(TAG, "[sendToUT]:", " args:", map);
        if (!com.alibaba.mtl.log.a.r) {
            map.put("_fuamf", "yes");
            t.send(map);
        } else if (map != null) {
            com.alibaba.mtl.log.a.a(map.get(LogField.PAGE.toString()), map.get(LogField.EVENTID.toString()), map.get(LogField.ARG1.toString()), map.get(LogField.ARG2.toString()), map.get(LogField.ARG3.toString()), map);
        }
    }
}
