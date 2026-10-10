package com.google.android.datatransport.runtime.d.a;

import android.database.Cursor;
import com.google.android.datatransport.runtime.d.a.D;
import java.util.Map;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class q implements D.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f12905a;

    private q(Map map) {
        this.f12905a = map;
    }

    public static D.a a(Map map) {
        return new q(map);
    }

    @Override // com.google.android.datatransport.runtime.d.a.D.a
    public Object apply(Object obj) {
        return D.a(this.f12905a, (Cursor) obj);
    }
}
