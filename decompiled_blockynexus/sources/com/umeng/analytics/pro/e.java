package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: UMDBManager.java */
/* JADX INFO: loaded from: classes5.dex */
class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SQLiteOpenHelper f20854b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Context f20855d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicInteger f20856a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SQLiteDatabase f20857c;

    /* JADX INFO: compiled from: UMDBManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final e f20858a = new e();

        private a() {
        }
    }

    public static e a(Context context) {
        if (f20855d == null && context != null) {
            f20855d = context.getApplicationContext();
            f20854b = d.a(f20855d);
        }
        return a.f20858a;
    }

    public synchronized void b() {
        try {
            if (this.f20856a.decrementAndGet() == 0) {
                this.f20857c.close();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private e() {
        this.f20856a = new AtomicInteger();
    }

    public synchronized SQLiteDatabase a() {
        if (this.f20856a.incrementAndGet() == 1) {
            this.f20857c = f20854b.getWritableDatabase();
        }
        return this.f20857c;
    }
}
