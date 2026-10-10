package com.google.android.datatransport.runtime.d.a;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.d.a.D;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class r implements D.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f12906a;

    private r(SQLiteDatabase sQLiteDatabase) {
        this.f12906a = sQLiteDatabase;
    }

    public static D.c a(SQLiteDatabase sQLiteDatabase) {
        return new r(sQLiteDatabase);
    }

    @Override // com.google.android.datatransport.runtime.d.a.D.c
    public Object a() {
        return D.a(this.f12906a);
    }
}
