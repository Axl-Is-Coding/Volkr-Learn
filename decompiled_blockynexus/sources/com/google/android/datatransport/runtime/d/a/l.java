package com.google.android.datatransport.runtime.d.a;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.d.a.D;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class l implements D.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final D f12897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.q f12898b;

    private l(D d2, com.google.android.datatransport.runtime.q qVar) {
        this.f12897a = d2;
        this.f12898b = qVar;
    }

    public static D.a a(D d2, com.google.android.datatransport.runtime.q qVar) {
        return new l(d2, qVar);
    }

    @Override // com.google.android.datatransport.runtime.d.a.D.a
    public Object apply(Object obj) {
        return D.b(this.f12897a, this.f12898b, (SQLiteDatabase) obj);
    }
}
