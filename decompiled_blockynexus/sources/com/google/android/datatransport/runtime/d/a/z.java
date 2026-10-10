package com.google.android.datatransport.runtime.d.a;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.d.a.D;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class z implements D.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12916a;

    private z(String str) {
        this.f12916a = str;
    }

    public static D.a a(String str) {
        return new z(str);
    }

    @Override // com.google.android.datatransport.runtime.d.a.D.a
    public Object apply(Object obj) {
        return D.a(this.f12916a, (SQLiteDatabase) obj);
    }
}
