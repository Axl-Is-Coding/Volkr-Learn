package com.bytedance.sdk.openadsdk.f.b;

import android.content.Context;
import android.database.Cursor;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.b.c;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: LogStatsCache.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f6747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f6748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f6749c = new AtomicBoolean(false);

    private b() {
        b();
    }

    public static b a() {
        if (f6747a == null) {
            synchronized (b.class) {
                if (f6747a == null) {
                    f6747a = new b();
                }
            }
        }
        return f6747a;
    }

    public void b() {
        if (this.f6749c.get() || o.a() == null) {
            return;
        }
        this.f6748b = o.a();
        this.f6749c.set(true);
    }

    public synchronized void c() {
        if (this.f6749c.get()) {
            try {
                com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f6748b, "logstats", "retry >=?", new String[]{String.valueOf(5)});
            } catch (Throwable unused) {
            }
        } else {
            b();
        }
    }

    /* JADX WARN: Finally extract failed */
    public synchronized List<c.a> d() {
        LinkedList linkedList = new LinkedList();
        if (!this.f6749c.get()) {
            b();
            return linkedList;
        }
        Cursor cursorA = com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f6748b, "logstats", new String[]{"id", "value"}, "retry <?", new String[]{String.valueOf(5)}, null, null, null);
        if (cursorA != null) {
            while (cursorA.moveToNext()) {
                try {
                    try {
                        linkedList.add(new c.a(cursorA.getString(cursorA.getColumnIndex("id")), new JSONObject(cursorA.getString(cursorA.getColumnIndex("value")))));
                    } catch (Exception unused) {
                    }
                } catch (Throwable th) {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    throw th;
                }
            }
            if (cursorA != null) {
                cursorA.close();
            }
        }
        return linkedList;
    }
}
