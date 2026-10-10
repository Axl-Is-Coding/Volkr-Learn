package com.google.android.datatransport.runtime.d.a;

import com.google.android.datatransport.runtime.d.a.D;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class t implements D.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final J f12908a;

    private t(J j) {
        this.f12908a = j;
    }

    public static D.c a(J j) {
        return new t(j);
    }

    @Override // com.google.android.datatransport.runtime.d.a.D.c
    public Object a() {
        return this.f12908a.getWritableDatabase();
    }
}
