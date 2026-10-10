package com.google.android.datatransport.runtime.d.a;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.d.a.D;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class m implements D.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final m f12899a = new m();

    private m() {
    }

    public static D.a a() {
        return f12899a;
    }

    @Override // com.google.android.datatransport.runtime.d.a.D.a
    public Object apply(Object obj) {
        return D.b((SQLiteDatabase) obj);
    }
}
