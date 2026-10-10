package b.f.a;

import android.util.Log;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: EventsTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f2595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f2596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e f2597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ExecutorService f2598d;

    public c(a aVar, d dVar) {
        if (aVar == null) {
            throw new InvalidParameterException("Null configuration not supported ");
        }
        if (aVar.c() == null) {
            throw new InvalidParameterException("Null formatter not supported ");
        }
        this.f2596b = aVar;
        this.f2595a = dVar;
        this.f2597c = aVar.c();
        this.f2598d = Executors.newSingleThreadExecutor();
    }

    private void b(String str) {
        this.f2598d.submit(new b(this, str));
    }

    public void a(String str, Map<String, Object> map) {
        a(String.format(Locale.ENGLISH, "%s %s", str, map.toString()));
        if (this.f2596b.a() && !str.isEmpty()) {
            HashMap map2 = new HashMap();
            map2.put("eventname", str);
            a(map2, this.f2595a.getData());
            a(map2, map);
            b(this.f2597c.a(map2));
        }
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        try {
            map.putAll(map2);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.f2596b.f()) {
            Log.d("EventsTracker", str);
        }
    }
}
