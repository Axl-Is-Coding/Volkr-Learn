package com.google.android.datatransport.runtime.d.a;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.d.a.D;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class n implements D.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12900a;

    private n(long j) {
        this.f12900a = j;
    }

    public static D.a a(long j) {
        return new n(j);
    }

    @Override // com.google.android.datatransport.runtime.d.a.D.a
    public Object apply(Object obj) {
        return Integer.valueOf(((SQLiteDatabase) obj).delete(com.umeng.analytics.pro.b.ao, "timestamp_ms < ?", new String[]{String.valueOf(this.f12900a)}));
    }
}
