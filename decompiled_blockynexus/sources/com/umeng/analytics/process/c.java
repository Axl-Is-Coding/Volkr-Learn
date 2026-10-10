package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: UMProcessDBManager.java */
/* JADX INFO: loaded from: classes5.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f20999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f21000b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f21001c;

    private c() {
    }

    static c a(Context context) {
        if (f20999a == null) {
            synchronized (c.class) {
                if (f20999a == null) {
                    f20999a = new c();
                }
            }
        }
        c cVar = f20999a;
        cVar.f21001c = context;
        return cVar;
    }

    private a c(String str) {
        if (this.f21000b.get(str) != null) {
            return this.f21000b.get(str);
        }
        a aVarA = a.a(this.f21001c, str);
        this.f21000b.put(str, aVarA);
        return aVarA;
    }

    synchronized void b(String str) {
        c(str).b();
    }

    /* JADX INFO: compiled from: UMProcessDBManager.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AtomicInteger f21002a = new AtomicInteger();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SQLiteOpenHelper f21003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private SQLiteDatabase f21004c;

        private a() {
        }

        static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.f21003b = b.a(appContext, str);
            return aVar;
        }

        synchronized void b() {
            try {
                if (this.f21002a.decrementAndGet() == 0) {
                    this.f21004c.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        synchronized SQLiteDatabase a() {
            if (this.f21002a.incrementAndGet() == 1) {
                this.f21004c = this.f21003b.getWritableDatabase();
            }
            return this.f21004c;
        }
    }

    synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }
}
