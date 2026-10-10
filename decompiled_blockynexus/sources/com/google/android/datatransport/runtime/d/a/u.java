package com.google.android.datatransport.runtime.d.a;

import android.database.Cursor;
import com.google.android.datatransport.runtime.d.a.D;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class u implements D.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final u f12909a = new u();

    private u() {
    }

    public static D.a a() {
        return f12909a;
    }

    @Override // com.google.android.datatransport.runtime.d.a.D.a
    public Object apply(Object obj) {
        return D.c((Cursor) obj);
    }
}
