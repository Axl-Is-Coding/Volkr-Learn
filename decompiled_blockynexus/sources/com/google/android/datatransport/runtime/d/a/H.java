package com.google.android.datatransport.runtime.d.a;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.d.a.J;

/* JADX INFO: compiled from: SchemaManager.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class H implements J.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final H f12867a = new H();

    private H() {
    }

    public static J.a a() {
        return f12867a;
    }

    @Override // com.google.android.datatransport.runtime.d.a.J.a
    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
