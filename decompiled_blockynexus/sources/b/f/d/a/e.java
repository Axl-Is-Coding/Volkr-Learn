package b.f.d.a;

import android.util.Log;
import b.f.d.a.g;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: ISNEventsTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f2632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b.f.a.c f2633b;

    private e() {
    }

    private static e a() {
        if (f2632a == null) {
            f2632a = new e();
        }
        return f2632a;
    }

    public static void a(b.f.a.a aVar, c cVar) {
        if (aVar != null) {
            try {
                a().f2633b = new b.f.a.c(aVar, cVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(g.a aVar) {
        a(aVar, new HashMap());
    }

    public static void a(g.a aVar, Map<String, Object> map) {
        b.f.a.c cVar = a().f2633b;
        if (cVar == null) {
            Log.d("sdk5Events", "logEvent failed eventsTracker doesn't exist");
            return;
        }
        if (map != null) {
            map.put("eventid", Integer.valueOf(aVar.f2641b));
        }
        cVar.a(aVar.f2640a, map);
    }
}
