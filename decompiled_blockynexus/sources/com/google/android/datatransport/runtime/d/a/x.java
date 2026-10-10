package com.google.android.datatransport.runtime.d.a;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.d.a.D;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class x implements D.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final D f12912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.q f12913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.l f12914c;

    private x(D d2, com.google.android.datatransport.runtime.q qVar, com.google.android.datatransport.runtime.l lVar) {
        this.f12912a = d2;
        this.f12913b = qVar;
        this.f12914c = lVar;
    }

    public static D.a a(D d2, com.google.android.datatransport.runtime.q qVar, com.google.android.datatransport.runtime.l lVar) {
        return new x(d2, qVar, lVar);
    }

    @Override // com.google.android.datatransport.runtime.d.a.D.a
    public Object apply(Object obj) {
        return D.a(this.f12912a, this.f12913b, this.f12914c, (SQLiteDatabase) obj);
    }
}
