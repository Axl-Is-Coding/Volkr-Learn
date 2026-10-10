package com.google.android.datatransport.runtime.d.a;

import android.database.Cursor;
import com.google.android.datatransport.runtime.d.a.D;
import java.util.List;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class o implements D.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final D f12901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f12902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.q f12903c;

    private o(D d2, List list, com.google.android.datatransport.runtime.q qVar) {
        this.f12901a = d2;
        this.f12902b = list;
        this.f12903c = qVar;
    }

    public static D.a a(D d2, List list, com.google.android.datatransport.runtime.q qVar) {
        return new o(d2, list, qVar);
    }

    @Override // com.google.android.datatransport.runtime.d.a.D.a
    public Object apply(Object obj) {
        return D.a(this.f12901a, this.f12902b, this.f12903c, (Cursor) obj);
    }
}
