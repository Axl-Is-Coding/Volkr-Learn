package com.google.android.datatransport.runtime.d.a;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.d.a.D;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class B implements D.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final D f12852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.q f12853b;

    private B(D d2, com.google.android.datatransport.runtime.q qVar) {
        this.f12852a = d2;
        this.f12853b = qVar;
    }

    public static D.a a(D d2, com.google.android.datatransport.runtime.q qVar) {
        return new B(d2, qVar);
    }

    @Override // com.google.android.datatransport.runtime.d.a.D.a
    public Object apply(Object obj) {
        return D.a(this.f12852a, this.f12853b, (SQLiteDatabase) obj);
    }
}
