package com.google.android.datatransport.runtime.d.a;

import android.database.Cursor;
import com.google.android.datatransport.runtime.d.a.D;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class p implements D.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final p f12904a = new p();

    private p() {
    }

    public static D.a a() {
        return f12904a;
    }

    @Override // com.google.android.datatransport.runtime.d.a.D.a
    public Object apply(Object obj) {
        return D.d((Cursor) obj);
    }
}
