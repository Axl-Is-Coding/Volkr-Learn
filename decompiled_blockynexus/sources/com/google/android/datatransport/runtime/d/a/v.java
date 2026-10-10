package com.google.android.datatransport.runtime.d.a;

import android.database.Cursor;
import com.google.android.datatransport.runtime.d.a.D;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class v implements D.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final v f12910a = new v();

    private v() {
    }

    public static D.a a() {
        return f12910a;
    }

    @Override // com.google.android.datatransport.runtime.d.a.D.a
    public Object apply(Object obj) {
        return Boolean.valueOf(((Cursor) obj).moveToNext());
    }
}
